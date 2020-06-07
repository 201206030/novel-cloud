package com.java2nb.novel.book.api.fallback;

import com.java2nb.novel.book.api.BookApi;
import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.entity.BookComment;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 小说微服务API接口降级处理类（服务提供端，默认降级处理）
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/6/7
 */
public class BookApiFallback implements BookApi {
    @Override
    public List<Book> queryBookByMinUpdateTime(Date minDate, int limit) {
        return null;
    }

    @Override
    public List<Book> queryBookByIds(List<Long> ids) {
        return new ArrayList<>();
    }

    @Override
    public List<Book> listRank(Byte type, Integer limit) {
        return new ArrayList<>();
    }

    @Override
    public Book queryBookById(Long id) {
        return null;
    }

    @Override
    public boolean addBookComment(Long userId, BookComment comment) {

        return false;

    }

    @Override
    public List<BookComment> listUserCommentByPage(Long userId, int page, int pageSize) {
        return new ArrayList<>();
    }

    @Override
    public List<Book> queryNetworkPicBooks(String localPicPrefix, int limit) {
        return new ArrayList<>();
    }

    @Override
    public boolean updateBookPic(String picUrl, Long bookId) {
        return false;
    }
}
