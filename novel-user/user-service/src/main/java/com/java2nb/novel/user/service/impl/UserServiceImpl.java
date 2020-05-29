package com.java2nb.novel.user.service.impl;

import com.github.pagehelper.PageHelper;
import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.entity.BookComment;
import com.java2nb.novel.common.bean.UserDetails;
import com.java2nb.novel.common.enums.ResponseStatus;
import com.java2nb.novel.common.exception.BusinessException;
import com.java2nb.novel.common.utils.IdWorker;
import com.java2nb.novel.common.utils.MD5Util;
import com.java2nb.novel.user.entity.User;
import com.java2nb.novel.user.entity.UserBookshelf;
import com.java2nb.novel.user.entity.UserFeedback;
import com.java2nb.novel.user.entity.UserReadHistory;
import com.java2nb.novel.user.feign.BookFeignClient;
import com.java2nb.novel.user.form.UserForm;
import com.java2nb.novel.user.mapper.*;
import com.java2nb.novel.user.service.UserService;
import com.java2nb.novel.user.vo.BookReadHistoryVO;
import com.java2nb.novel.user.vo.BookShelfVO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static com.java2nb.novel.user.mapper.UserBookshelfDynamicSqlSupport.userBookshelf;
import static com.java2nb.novel.user.mapper.UserReadHistoryDynamicSqlSupport.userReadHistory;
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
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    private final UserBookshelfMapper userBookshelfMapper;

    private final UserReadHistoryMapper userReadHistoryMapper;

    private final UserFeedbackMapper userFeedbackMapper;

    private final BookFeignClient bookFeignClient;


    @Override
    public User queryByUsernameAndPassword(String username, String password) {

        List<User> users = userMapper.selectMany(
                select(UserDynamicSqlSupport.id, UserDynamicSqlSupport.username, UserDynamicSqlSupport.nickName)
                        .from(UserDynamicSqlSupport.user)
                        .where(UserDynamicSqlSupport.username, isEqualTo(username))
                        .and(UserDynamicSqlSupport.password, isEqualTo(MD5Util.MD5Encode(password, Charsets.UTF_8.name())))
                        .limit(1)
                        .build()
                        .render(RenderingStrategies.MYBATIS3));
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public UserDetails login(UserForm form) {
        //根据用户名密码查询记录
        User user = queryByUsernameAndPassword(form.getUsername(), form.getPassword());
        if (user == null) {
            throw new BusinessException(ResponseStatus.USERNAME_PASS_ERROR);
        }
        //生成UserDetail对象并返回
        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        userDetails.setNickName(user.getNickName());
        userDetails.setUsername(form.getUsername());
        return userDetails;
    }

    @Override
    public List<User> queryById(List<Long> ids) {
        return userMapper.selectMany(
                select(UserDynamicSqlSupport.id, UserDynamicSqlSupport.username,
                        UserDynamicSqlSupport.userPhoto)
                        .from(UserDynamicSqlSupport.user)
                        .where(UserDynamicSqlSupport.id, isIn(ids)).build()
                        .render(RenderingStrategies.MYBATIS3));
    }

    @Override
    public UserDetails register(UserForm form) {
        //查询用户名是否已注册
        SelectStatementProvider selectStatement = select(count(UserDynamicSqlSupport.id))
                .from(UserDynamicSqlSupport.user)
                .where(UserDynamicSqlSupport.username, isEqualTo(form.getUsername()))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        long count = userMapper.count(selectStatement);
        if (count > 0) {
            //用户名已注册
            throw new BusinessException(ResponseStatus.USERNAME_EXIST);
        }
        User entity = new User();
        BeanUtils.copyProperties(form, entity);
        //数据库生成注册记录
        Long id = new IdWorker().nextId();
        entity.setId(id);
        entity.setNickName(entity.getUsername());
        Date currentDate = new Date();
        entity.setCreateTime(currentDate);
        entity.setUpdateTime(currentDate);
        entity.setPassword(MD5Util.MD5Encode(entity.getPassword(), Charsets.UTF_8.name()));
        userMapper.insertSelective(entity);
        //生成UserDetail对象并返回
        UserDetails userDetails = new UserDetails();
        userDetails.setId(id);
        userDetails.setUsername(entity.getUsername());
        userDetails.setNickName(entity.getNickName());
        return userDetails;
    }

    @Override
    public Boolean queryIsInShelf(Long userId, Long bookId) {
        SelectStatementProvider selectStatement = select(count(UserBookshelfDynamicSqlSupport.id))
                .from(userBookshelf)
                .where(UserBookshelfDynamicSqlSupport.userId, isEqualTo(userId))
                .and(UserBookshelfDynamicSqlSupport.bookId, isEqualTo(bookId))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return userBookshelfMapper.count(selectStatement) > 0;
    }

    @Override
    public void addToBookShelf(Long userId, Long bookId, Long preContentId) {
        if (!queryIsInShelf(userId, bookId)) {
            UserBookshelf shelf = new UserBookshelf();
            shelf.setUserId(userId);
            shelf.setBookId(bookId);
            shelf.setPreContentId(preContentId);
            shelf.setCreateTime(new Date());
            userBookshelfMapper.insert(shelf);
        }
    }

    @Override
    public void removeFromBookShelf(Long userId, Long bookId) {
        DeleteStatementProvider deleteStatement = deleteFrom(userBookshelf)
                .where(UserBookshelfDynamicSqlSupport.userId, isEqualTo(userId))
                .and(UserBookshelfDynamicSqlSupport.bookId, isEqualTo(bookId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        userBookshelfMapper.delete(deleteStatement);
    }

    @Override
    public List<BookShelfVO> listBookShelfByPage(Long userId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<UserBookshelf> userBookshelves = userBookshelfMapper.selectMany(
                select(UserBookshelfDynamicSqlSupport.bookId, UserBookshelfDynamicSqlSupport.preContentId)
                        .from(userBookshelf)
                        .where(UserBookshelfDynamicSqlSupport.userId, isEqualTo(userId))
                        .orderBy(UserBookshelfDynamicSqlSupport.createTime.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3));

        List<Book> books = bookFeignClient.queryBookByIds(userBookshelves.stream().map(UserBookshelf::getBookId).collect(Collectors.toList()));
        Map<Long, Book> booksById = books.stream().collect(Collectors.toMap(Book::getId, Function.identity(), (key1, key2) -> key2));

        List<BookShelfVO> resultList = new ArrayList<>(booksById.size());
        for (UserBookshelf bookshelf : userBookshelves) {
            BookShelfVO bookShelfVO = new BookShelfVO();
            BeanUtils.copyProperties(bookshelf, bookShelfVO);
            Book book = booksById.get(bookshelf.getBookId());
            if (book != null) {
                BeanUtils.copyProperties(book, bookShelfVO);
                resultList.add(bookShelfVO);
            }

        }


        return resultList;
    }

    @Override
    public List<BookReadHistoryVO> listReadHistoryByPage(Long userId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        List<UserReadHistory> userReadHistories = userReadHistoryMapper.selectMany(
                select(UserReadHistoryDynamicSqlSupport.bookId, UserReadHistoryDynamicSqlSupport.preContentId)
                        .from(userReadHistory)
                        .where(UserReadHistoryDynamicSqlSupport.userId, isEqualTo(userId))
                        .orderBy(UserReadHistoryDynamicSqlSupport.createTime.descending())
                        .build()
                        .render(RenderingStrategies.MYBATIS3));

        List<Book> books = bookFeignClient.queryBookByIds(userReadHistories.stream().map(UserReadHistory::getBookId).collect(Collectors.toList()));

        Map<Long, Book> booksById = books.stream().collect(Collectors.toMap(Book::getId, Function.identity(), (key1, key2) -> key2));

        List<BookReadHistoryVO> resultList = new ArrayList<>(booksById.size());
        for (UserReadHistory readHistory : userReadHistories) {
            BookReadHistoryVO readHistoryVO = new BookReadHistoryVO();
            BeanUtils.copyProperties(readHistory, readHistoryVO);
            Book book = booksById.get(readHistory.getBookId());
            if (book != null) {
                BeanUtils.copyProperties(book, readHistoryVO);
                resultList.add(readHistoryVO);
            }

        }


        return resultList;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void addReadHistory(Long userId, Long bookId, Long preContentId) {

        Date currentDate = new Date();
        //删除该书以前的历史记录
        DeleteStatementProvider deleteStatement = deleteFrom(userReadHistory)
                .where(UserReadHistoryDynamicSqlSupport.bookId, isEqualTo(bookId))
                .and(UserReadHistoryDynamicSqlSupport.userId, isEqualTo(userId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        userReadHistoryMapper.delete(deleteStatement);

        //插入该书新的历史记录
        UserReadHistory userReadHistory = new UserReadHistory();
        userReadHistory.setBookId(bookId);
        userReadHistory.setUserId(userId);
        userReadHistory.setPreContentId(preContentId);
        userReadHistory.setCreateTime(currentDate);
        userReadHistory.setUpdateTime(currentDate);
        userReadHistoryMapper.insertSelective(userReadHistory);


        //更新书架的阅读历史
        UpdateStatementProvider updateStatement = update(userBookshelf)
                .set(UserBookshelfDynamicSqlSupport.preContentId)
                .equalTo(preContentId)
                .set(UserBookshelfDynamicSqlSupport.updateTime)
                .equalTo(currentDate)
                .where(UserBookshelfDynamicSqlSupport.userId, isEqualTo(userId))
                .and(UserBookshelfDynamicSqlSupport.bookId, isEqualTo(bookId))
                .build()
                .render(RenderingStrategies.MYBATIS3);

        userBookshelfMapper.update(updateStatement);


    }

    @Override
    public void addFeedBack(Long userId, String content) {
        UserFeedback feedback = new UserFeedback();
        feedback.setUserId(userId);
        feedback.setContent(content);
        feedback.setCreateTime(new Date());
        userFeedbackMapper.insertSelective(feedback);
    }


    @Override
    public List<UserFeedback> listUserFeedBackByPage(Long userId, int page, int pageSize) {
        PageHelper.startPage(page, pageSize);
        return userFeedbackMapper.selectMany(select(UserFeedbackDynamicSqlSupport.content, UserFeedbackDynamicSqlSupport.createTime)
                .from(UserFeedbackDynamicSqlSupport.userFeedback)
                .where(UserFeedbackDynamicSqlSupport.userId, isEqualTo(userId))
                .orderBy(UserFeedbackDynamicSqlSupport.id.descending())
                .build()
                .render(RenderingStrategies.MYBATIS3));
    }

    @Override
    public User userInfo(Long userId) {
        SelectStatementProvider selectStatement = select(UserDynamicSqlSupport.username, UserDynamicSqlSupport.nickName,
                UserDynamicSqlSupport.userPhoto, UserDynamicSqlSupport.userSex, UserDynamicSqlSupport.accountBalance)
                .from(UserDynamicSqlSupport.user)
                .where(UserDynamicSqlSupport.id, isEqualTo(userId))
                .limit(1)
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return userMapper.selectMany(selectStatement).get(0);
    }

    @Override
    public void updateUserInfo(Long userId, User user) {
        User updateUser = new User();
        updateUser.setId(userId);
        updateUser.setNickName(user.getNickName());
        updateUser.setUserSex(user.getUserSex());
        updateUser.setUpdateTime(new Date());
        userMapper.updateByPrimaryKeySelective(updateUser);

    }

    @Override
    public void updatePassword(Long userId, String oldPassword, String newPassword) {
        SelectStatementProvider selectStatement = select(UserDynamicSqlSupport.password)
                .from(UserDynamicSqlSupport.user)
                .where(UserDynamicSqlSupport.id, isEqualTo(userId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        if (!userMapper.selectMany(selectStatement).get(0).getPassword().equals(MD5Util.MD5Encode(oldPassword, Charsets.UTF_8.name()))) {
            throw new BusinessException(ResponseStatus.OLD_PASSWORD_ERROR);
        }
        UpdateStatementProvider updateStatement = update(UserDynamicSqlSupport.user)
                .set(UserDynamicSqlSupport.password)
                .equalTo(MD5Util.MD5Encode(newPassword, Charsets.UTF_8.name()))
                .where(UserDynamicSqlSupport.id, isEqualTo(userId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        userMapper.update(updateStatement);

    }



}
