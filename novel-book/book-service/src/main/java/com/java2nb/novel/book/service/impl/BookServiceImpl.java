package com.java2nb.novel.book.service.impl;

import com.github.pagehelper.PageHelper;
import com.java2nb.novel.book.entity.*;
import com.java2nb.novel.book.feign.UserFeignClient;
import com.java2nb.novel.book.mapper.*;
import com.java2nb.novel.book.service.BookService;
import com.java2nb.novel.book.vo.BookCommentVO;
import com.java2nb.novel.common.enums.ResponseStatus;
import com.java2nb.novel.common.exception.BusinessException;
import com.java2nb.novel.common.utils.BeanUtil;
import com.java2nb.novel.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.StringUtils;
import org.mybatis.dynamic.sql.SortSpecification;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.orderbyhelper.OrderByHelper;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.java2nb.novel.book.mapper.BookDynamicSqlSupport.book;
import static org.mybatis.dynamic.sql.SqlBuilder.*;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * 小说服务接口实现
 *
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

    private final BookCategoryMapper bookCategoryMapper;

    private final BookIndexMapper bookIndexMapper;

    private final BookContentMapper bookContentMapper;

    private final BookCommentMapper bookCommentMapper;

    private final UserFeignClient userFeignClient;

    @Override
    public List<Book> queryBookByMinUpdateTime(Date minDate, int limit) {
        return bookMapper.selectMany(select(book.allColumns())
                .from(book)
                .where(BookDynamicSqlSupport.updateTime, isGreaterThan(minDate))
                .orderBy(BookDynamicSqlSupport.updateTime)
                .limit(limit)
                .build()
                .render(RenderingStrategies.MYBATIS3));
    }

    @Override
    public List<Book> queryBookByIds(List<Long> ids) {
        return bookMapper.selectMany(select(BookDynamicSqlSupport.id, BookDynamicSqlSupport.catId, BookDynamicSqlSupport.catName,
                BookDynamicSqlSupport.bookName, BookDynamicSqlSupport.authorName,
                BookDynamicSqlSupport.lastIndexId, BookDynamicSqlSupport.lastIndexName, BookDynamicSqlSupport.lastIndexUpdateTime,
                BookDynamicSqlSupport.picUrl, BookDynamicSqlSupport.bookDesc, BookDynamicSqlSupport.score)
                .from(book)
                .where(BookDynamicSqlSupport.id, isIn(ids))
                .build()
                .render(RenderingStrategies.MYBATIS3)
        );
    }

    @Override
    public List<Book> listRank(Byte type, Integer limit) {
        SortSpecification sortSpecification = BookDynamicSqlSupport.visitCount.descending();
        switch (type) {
            case 1: {
                //最新入库排序
                sortSpecification = BookDynamicSqlSupport.createTime.descending();
                break;
            }
            case 2: {
                //最新更新时间排序
                sortSpecification = BookDynamicSqlSupport.lastIndexUpdateTime.descending();
                break;
            }
            case 3: {
                //评论数量排序
                sortSpecification = BookDynamicSqlSupport.commentCount.descending();
                break;
            }
            default: {
                break;
            }
        }
        SelectStatementProvider selectStatement =
                select(BookDynamicSqlSupport.id, BookDynamicSqlSupport.catId,
                        BookDynamicSqlSupport.catName, BookDynamicSqlSupport.bookName,
                        BookDynamicSqlSupport.lastIndexId, BookDynamicSqlSupport.lastIndexName,
                        BookDynamicSqlSupport.authorId, BookDynamicSqlSupport.authorName,
                        BookDynamicSqlSupport.picUrl, BookDynamicSqlSupport.bookDesc,
                        BookDynamicSqlSupport.wordCount, BookDynamicSqlSupport.lastIndexUpdateTime)
                        .from(book)
                        .where(BookDynamicSqlSupport.wordCount, isGreaterThan(0))
                        .orderBy(sortSpecification)
                        .limit(limit)
                        .build()
                        .render(RenderingStrategies.MYBATIS3);
        return bookMapper.selectMany(selectStatement);
    }

    @Override
    public List<BookCategory> listBookCategory() {
        SelectStatementProvider selectStatementProvider = select(BookCategoryDynamicSqlSupport.id, BookCategoryDynamicSqlSupport.name, BookCategoryDynamicSqlSupport.workDirection)
                .from(BookCategoryDynamicSqlSupport.bookCategory)
                .orderBy(BookCategoryDynamicSqlSupport.sort)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return bookCategoryMapper.selectMany(selectStatementProvider);
    }

    @Override
    public Book queryBookDetail(Long id) {
        SelectStatementProvider selectStatement = select(BookDynamicSqlSupport.book.allColumns())
                .from(BookDynamicSqlSupport.book)
                .where(BookDynamicSqlSupport.id, isEqualTo(id))
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<Book> books = bookMapper.selectMany(selectStatement);
        return books.size() > 0 ? books.get(0) : null;
    }

    @Override
    public void addVisitCount(Long bookId, int addCount) {
        bookMapper.addVisitCount(bookId, addCount);

    }

    @Override
    public long queryIndexCount(Long bookId) {
        SelectStatementProvider selectStatement = select(count(BookIndexDynamicSqlSupport.id))
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.bookId, isEqualTo(bookId))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return bookIndexMapper.count(selectStatement);
    }

    @Override
    public BookContent queryBookContent(Long bookIndexId) {
        SelectStatementProvider selectStatement = select(BookContentDynamicSqlSupport.id, BookContentDynamicSqlSupport.content)
                .from(BookContentDynamicSqlSupport.bookContent)
                .where(BookContentDynamicSqlSupport.indexId, isEqualTo(bookIndexId))
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return bookContentMapper.selectMany(selectStatement).get(0);
    }

    @Override
    public List<Book> listRecBookByCatId(Integer catId) {
        return bookMapper.listRecBookByCatId(catId);
    }

    @Override
    public List<BookCommentVO> listBookCommentByPage(Long bookId, int page, int pageSize) {
        //分页查询小说评论数据
        PageHelper.startPage(page, pageSize);
        List<BookComment> bookCommentList = bookCommentMapper.selectMany(
                select(BookCommentDynamicSqlSupport.id, BookCommentDynamicSqlSupport.bookId,
                        BookCommentDynamicSqlSupport.createUserId,
                        BookCommentDynamicSqlSupport.commentContent, BookCommentDynamicSqlSupport.replyCount,
                        BookCommentDynamicSqlSupport.createTime)
                        .from(BookCommentDynamicSqlSupport.bookComment)
                        .where(BookCommentDynamicSqlSupport.bookId, isEqualTo(bookId))
                        .orderBy(BookCommentDynamicSqlSupport.createTime.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3));

        //根据评论人ID集合查询出评论人集合数据
        List<User> users = userFeignClient.queryById(bookCommentList.stream().map(BookComment::getCreateUserId).collect(Collectors.toList()));

        Map<Long, User> userMap = users.stream().collect(Collectors.toMap(User::getId, Function.identity(), (key1, key2) -> key2));

        //将评论数据和评论人数据关联起来
        List<BookCommentVO> resultList = new ArrayList<>(bookCommentList.size());
        for (BookComment bookComment : bookCommentList) {
            BookCommentVO bookCommentVO = new BookCommentVO();
            BeanUtils.copyProperties(bookComment, bookCommentVO);
            User user = userMap.get(bookComment.getCreateUserId());
            if (user != null) {
                bookCommentVO.setCreateUserName(user.getUsername());
                bookCommentVO.setCreateUserPhoto(user.getUserPhoto());
            }
            resultList.add(bookCommentVO);
        }

        return resultList;
    }

    @Override
    public List<BookIndex> listNewIndex(Long bookId, String orderBy, Integer limit) {
        if (StringUtils.isNotBlank(orderBy)) {
            OrderByHelper.orderBy(orderBy);
        }
        if (limit != null) {
            PageHelper.startPage(1, limit);
        }

        SelectStatementProvider selectStatement = select(BookIndexDynamicSqlSupport.id, BookIndexDynamicSqlSupport.bookId,
                BookIndexDynamicSqlSupport.indexNum, BookIndexDynamicSqlSupport.indexName,
                BookIndexDynamicSqlSupport.updateTime, BookIndexDynamicSqlSupport.isVip)
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.bookId, isEqualTo(bookId))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return bookIndexMapper.selectMany(selectStatement);
    }

    @Override
    public Long queryFirstBookIndexId(Long bookId) {
        SelectStatementProvider selectStatement = select(BookIndexDynamicSqlSupport.id)
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.bookId, isEqualTo(bookId))
                .orderBy(BookIndexDynamicSqlSupport.indexNum)
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return bookIndexMapper.selectMany(selectStatement).get(0).getId();
    }

    @Override
    public BookIndex queryBookIndex(Long bookIndexId) {
        SelectStatementProvider selectStatement = select(BookIndexDynamicSqlSupport.id, BookIndexDynamicSqlSupport.bookId, BookIndexDynamicSqlSupport.indexNum, BookIndexDynamicSqlSupport.indexName, BookIndexDynamicSqlSupport.wordCount, BookIndexDynamicSqlSupport.updateTime, BookIndexDynamicSqlSupport.isVip)
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.id, isEqualTo(bookIndexId))
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return bookIndexMapper.selectMany(selectStatement).get(0);
    }

    @Override
    public Map<String, Long> queryPreAndNextBookIndexId(Long bookId, Integer indexNum) {
        Map<String, Long> result = new HashMap<>(2);
        SelectStatementProvider selectStatement = select(BookIndexDynamicSqlSupport.id)
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.bookId, isEqualTo(bookId))
                .and(BookIndexDynamicSqlSupport.indexNum, isLessThan(indexNum))
                .orderBy(BookIndexDynamicSqlSupport.indexNum.descending())
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        List<BookIndex> list = bookIndexMapper.selectMany(selectStatement);
        if (list.size() == 0) {
            result.put("preBookIndexId", 0L);
        } else {
            result.put("preBookIndexId", list.get(0).getId());
        }

        selectStatement = select(BookIndexDynamicSqlSupport.id)
                .from(BookIndexDynamicSqlSupport.bookIndex)
                .where(BookIndexDynamicSqlSupport.bookId, isEqualTo(bookId))
                .and(BookIndexDynamicSqlSupport.indexNum, isGreaterThan(indexNum))
                .orderBy(BookIndexDynamicSqlSupport.indexNum)
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        list = bookIndexMapper.selectMany(selectStatement);
        if (list.size() == 0) {
            result.put("nextBookIndexId", 0L);
        } else {
            result.put("nextBookIndexId", list.get(0).getId());
        }


        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addBookComment(Long userId, BookComment comment) {
        //判断该用户是否已评论过该书籍
        SelectStatementProvider selectStatement = select(count(BookCommentDynamicSqlSupport.id))
                .from(BookCommentDynamicSqlSupport.bookComment)
                .where(BookCommentDynamicSqlSupport.createUserId, isEqualTo(userId))
                .and(BookCommentDynamicSqlSupport.bookId, isEqualTo(comment.getBookId()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        if (bookCommentMapper.count(selectStatement) > 0) {
            throw new BusinessException(ResponseStatus.HAS_COMMENTS);
        }
        //增加评论
        comment.setCreateUserId(userId);
        comment.setCreateTime(new Date());
        bookCommentMapper.insertSelective(comment);
        //增加书籍评论数
        bookMapper.addCommentCount(comment.getBookId());

    }

    @Override
    public List<BookComment> listUserCommentByPage(Long userId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return bookCommentMapper.selectMany(
                select(BookCommentDynamicSqlSupport.id, BookCommentDynamicSqlSupport.bookId,
                        BookCommentDynamicSqlSupport.createUserId,
                        BookCommentDynamicSqlSupport.commentContent, BookCommentDynamicSqlSupport.replyCount,
                        BookCommentDynamicSqlSupport.createTime)
                        .from(BookCommentDynamicSqlSupport.bookComment)
                        .where(BookCommentDynamicSqlSupport.createUserId, isEqualTo(userId))
                        .orderBy(BookCommentDynamicSqlSupport.createTime.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3));
    }

    @Override
    public List<Book> queryNetworkPicBooks(String localPicPrefix, Integer limit) {


        return bookMapper.selectMany(
                select(BookDynamicSqlSupport.id, BookDynamicSqlSupport.picUrl)
                        .from(book)
                        .where(BookDynamicSqlSupport.picUrl, isLike("http%"))
                        .and(BookDynamicSqlSupport.picUrl, isNotLike(localPicPrefix))
                        .limit(limit)
                        .build()
                .render(RenderingStrategies.MYBATIS3));
    }

    @Override
    public void updateBookPic(String picUrl, Long bookId) {

        bookMapper.update(update(book)
                .set(BookDynamicSqlSupport.picUrl)
                .equalTo(picUrl)
                .set(BookDynamicSqlSupport.updateTime)
                .equalTo(new Date())
                .where(BookDynamicSqlSupport.id, isEqualTo(bookId))
                .build()
                .render(RenderingStrategies.MYBATIS3));

    }


}
