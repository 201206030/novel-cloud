package com.java2nb.novel.book.service;

import com.java2nb.novel.book.entity.Book;

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

    /**
     * 根据小说ID集合查询书籍列表
     * @param ids 小说ID集合
     * @return 书籍列表
     * */
    List<Book> queryBookByIds(List<Long> ids);

    /**
     * 小说排行数据查询列表
     * @param type 排行类型，1：更新排行，2：新书排行，3评论排行
     * @param limit 查询数量
     * @return 书籍列表
     * */
    List<Book> listRank(Byte type, Integer limit);
}
