package com.java2nb.novel.home.service;


import com.java2nb.novel.home.entity.HomeBook;
import com.java2nb.novel.home.entity.HomeFriendLink;
import com.java2nb.novel.home.vo.HomeBookVO;
import com.java2nb.novel.news.entity.News;

import java.util.List;

/**
 * 首页服务接口
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
public interface HomeService {

    /**
     * 首页小说推荐数据查询
     * @return 首页推荐的小说数据
     * */
    List<HomeBookVO> listHomeBook();


    /**
     * 首页友情链接查询
     * @return 友情链接集合
     * */
    List<HomeFriendLink> listFriendLink();

    /**
     * 查询首页新闻
     * @return 新闻列表集合
     * */
    List<News> listIndexNews();
}
