package com.java2nb.novel.news.service;


import com.java2nb.novel.news.entity.News;
import com.java2nb.novel.news.vo.NewsVO;

import java.util.List;

/**
 * 新闻服务接口
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
public interface NewsService {

    /**
     * 分页查询新闻列表接口
     * @param page 查询页码
     * @param pageSize 分页大小
     * @return 新闻列表集合
     * */
    List<NewsVO> listByPage(int page, int pageSize);

    /**
     * 查询最新新闻集合
     * @param limit 查询条数
     * @return 新闻集合
     * */
    List<News> listLastIndexNews(int limit);

    /**
     * 查询新闻
     * @param newsId 新闻id
     * @return 新闻
     * */
    News queryNewsInfo(Long newsId);
}
