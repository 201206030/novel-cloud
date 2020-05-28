package com.java2nb.novel.news.controller.api;

import com.java2nb.novel.news.entity.News;
import com.java2nb.novel.news.service.NewsService;
import com.java2nb.novel.news.vo.NewsVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

/**
 * 新闻微服务API接口（内部调用）
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@RestController
@RequestMapping(("api/news"))
@ApiIgnore
@RequiredArgsConstructor
public class NewsApi {

    private final NewsService newsService;

    /**
     * 查询最新新闻集合
     * @param limit 查询条数
     * @return 新闻集合
     * */
    @GetMapping("listLastIndexNews")
    List<News> listLastIndexNews(@RequestParam("limit") int limit){

        return newsService.listLastIndexNews(limit);

    }



}
