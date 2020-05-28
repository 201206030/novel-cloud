package com.java2nb.novel.news.api;

import com.java2nb.novel.news.entity.News;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * 新闻微服务API接口定义（内部）
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
public interface NewsApi {

    /**
     * 查询最新新闻集合
     * @param limit 查询条数
     * @return 新闻集合
     * */
    @GetMapping("api/news/listLastIndexNews")
    List<News> listLastIndexNews(@RequestParam("limit") int limit);


}
