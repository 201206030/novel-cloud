package com.java2nb.novel.book.service;

import com.java2nb.novel.book.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Date;
import java.util.List;

/**
 * 小说服务接口
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
public interface BookService {

    /**
     * 根据最小更新时间分页查询书籍列表
     * @param minDate 最小时间，包括该时间
     * @param limit 查询数量
     * @return 书籍列表
     * */
    List<Book> queryBookByMinUpdateTime(Date minDate, int limit);
}
