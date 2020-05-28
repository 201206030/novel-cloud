package com.java2nb.novel.home.controller;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.vo.BookVO;
import com.java2nb.novel.common.bean.PageBean;
import com.java2nb.novel.common.bean.ResultBean;
import com.java2nb.novel.home.entity.HomeFriendLink;
import com.java2nb.novel.home.service.HomeService;
import com.java2nb.novel.home.vo.HomeBookVO;
import com.java2nb.novel.news.entity.News;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 首页微服务对外接口
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@RestController
@RequestMapping("home")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "首页相关接口")
public class HomeController {

    private final HomeService homeService;

    /**
     * 首页小说推荐数据查询接口
     * */
    @ApiOperation("首页小说推荐列表查询接口")
    @GetMapping("book")
    public ResultBean<List<HomeBookVO>> listHomeBook(){
        return ResultBean.ok(homeService.listHomeBook());
    }

    /**
     * 首页友情链接查询接口
     * */
    @ApiOperation("首页友情链接查询接口")
    @GetMapping("friendLink")
    public ResultBean<List<HomeFriendLink>> listIndexLink(){
        return ResultBean.ok(homeService.listFriendLink());
    }

    /**
     * 首页新闻查询接口
     * */
    @ApiOperation("首页新闻查询接口")
    @GetMapping("news")
    public ResultBean<List<News>> listIndexNews(){
        return ResultBean.ok(homeService.listIndexNews());
    }


    /**
     * 首页点击榜单查询接口
     * */
    @ApiOperation("首页点击榜单查询接口")
    @GetMapping("listClickRank")
    public ResultBean<List<Book>> listClickRank(){
        return ResultBean.ok(homeService.listClickRank());
    }
    /**
     * 首页新书榜单查询接口
     * */
    @ApiOperation("首页点击榜单查询接口")
    @GetMapping("listNewRank")
    public ResultBean<List<Book>> listNewRank(){
        return ResultBean.ok(homeService.listNewRank());
    }

    /**
     * 首页更新榜单查询接口
     * */
    @ApiOperation("首页点击榜单查询接口")
    @GetMapping("listUpdateRank")
    public ResultBean<List<BookVO>> listUpdateRank(){
        return ResultBean.ok(homeService.listUpdateRank());
    }

}
