package com.java2nb.novel.book.api;

import com.java2nb.novel.book.entity.Book;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 小说微服务API接口定义（内部）
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
public interface BookApi {

    /**
     * 根据最小更新时间分页查询书籍列表
     * @param minDate 最小时间，包括该时间
     * @param limit 查询数量
     * @return 书籍列表
     * */
    @GetMapping("api/book/queryBookByMinUpdateTime")
    List<Book> queryBookByMinUpdateTime(@RequestParam("minDate") Date minDate,@RequestParam("limit") int limit);
}
