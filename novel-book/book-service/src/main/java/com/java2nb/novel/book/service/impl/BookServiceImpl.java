package com.java2nb.novel.book.service.impl;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.mapper.BookDynamicSqlSupport;
import com.java2nb.novel.book.mapper.BookMapper;
import com.java2nb.novel.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.mybatis.dynamic.sql.SortSpecification;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

import static com.java2nb.novel.book.mapper.BookDynamicSqlSupport.book;
import static org.mybatis.dynamic.sql.SqlBuilder.isGreaterThan;
import static org.mybatis.dynamic.sql.SqlBuilder.isIn;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * 小说服务接口实现
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {

    private final BookMapper bookMapper;

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
        return bookMapper.selectMany(select(BookDynamicSqlSupport.id,BookDynamicSqlSupport.bookName,BookDynamicSqlSupport.authorName,
                BookDynamicSqlSupport.picUrl,BookDynamicSqlSupport.bookDesc,BookDynamicSqlSupport.score)
                .from(book)
                .where(BookDynamicSqlSupport.id,isIn(ids))
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
}
