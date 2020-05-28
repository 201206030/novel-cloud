package com.java2nb.novel.home.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.vo.BookVO;
import com.java2nb.novel.common.cache.CacheKey;
import com.java2nb.novel.common.cache.CacheService;
import com.java2nb.novel.common.utils.BeanUtil;
import com.java2nb.novel.common.utils.Constants;
import com.java2nb.novel.home.entity.HomeBook;
import com.java2nb.novel.home.entity.HomeFriendLink;
import com.java2nb.novel.home.feign.BookFeignClient;
import com.java2nb.novel.home.feign.NewsFeignClient;
import com.java2nb.novel.home.mapper.HomeBookDynamicSqlSupport;
import com.java2nb.novel.home.mapper.HomeBookMapper;
import com.java2nb.novel.home.mapper.HomeFriendLinkDynamicSqlSupport;
import com.java2nb.novel.home.mapper.HomeFriendLinkMapper;
import com.java2nb.novel.home.service.HomeService;
import com.java2nb.novel.home.vo.HomeBookVO;
import com.java2nb.novel.news.entity.News;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * 首页服务接口实现
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@Service
@RequiredArgsConstructor
public class HomeServiceImpl implements HomeService {

    private final CacheService cacheService;

    private final BookFeignClient bookFeignClient;

    private final HomeBookMapper homeBookMapper;

    private final HomeFriendLinkMapper homeFriendLinkMapper;

    private final NewsFeignClient newsFeignClient;

    @SneakyThrows
    @Override
    public List<HomeBookVO> listHomeBook() {
        String result = cacheService.get(CacheKey.INDEX_BOOK_SETTINGS_KEY);
        if (result == null || result.length() < Constants.OBJECT_JSON_CACHE_EXIST_LENGTH) {
            List<HomeBook> list = homeBookMapper.selectMany(
                    select(HomeBookDynamicSqlSupport.bookId,HomeBookDynamicSqlSupport.type)
            .from(HomeBookDynamicSqlSupport.homeBook)
            .orderBy(HomeBookDynamicSqlSupport.type,HomeBookDynamicSqlSupport.sort)
                            .build()
                            .render(RenderingStrategies.MYBATIS3));
            List<Book> books = bookFeignClient.queryBookByIds(list.stream().map(HomeBook::getBookId).collect(Collectors.toList()));
            Map<Long, Book> booksById = books.stream().collect(Collectors.toMap(Book::getId, Function.identity(),(key1, key2) -> key2));

            List<HomeBookVO> resultList = new ArrayList<>(booksById.size());
            for(HomeBook homeBook : list){
                HomeBookVO homeBookVO = new HomeBookVO();
                BeanUtils.copyProperties(homeBook,homeBookVO);
                Book book = booksById.get(homeBook.getBookId());
                if(book != null){
                    BeanUtils.copyProperties(book,homeBookVO);
                    resultList.add(homeBookVO);
                }

            }

            result = new ObjectMapper().writeValueAsString(resultList);
            cacheService.set(CacheKey.INDEX_BOOK_SETTINGS_KEY, result);
        }
        return new ObjectMapper().readValue(result, List.class);
    }

    @Override
    public List<HomeFriendLink> listFriendLink() {
        List<HomeFriendLink> result = (List<HomeFriendLink>) cacheService.getObject(CacheKey.INDEX_LINK_KEY);
        if(result == null || result.size() == 0) {
            SelectStatementProvider selectStatement =
                    select(HomeFriendLinkDynamicSqlSupport.linkName,HomeFriendLinkDynamicSqlSupport.linkUrl)
                    .from(HomeFriendLinkDynamicSqlSupport.homeFriendLink)
                    .where(HomeFriendLinkDynamicSqlSupport.isOpen,isEqualTo((byte)1))
                    .orderBy(HomeFriendLinkDynamicSqlSupport.sort)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            result =  homeFriendLinkMapper.selectMany(selectStatement);
            cacheService.setObject(CacheKey.INDEX_LINK_KEY,result);
        }
        return result;
    }

    @Override
    public List<News> listIndexNews() {
        List<News> result = (List<News>) cacheService.getObject(CacheKey.INDEX_NEWS_KEY);
        if(result == null || result.size() == 0) {
            result = newsFeignClient.listLastIndexNews(2);
            cacheService.setObject(CacheKey.INDEX_NEWS_KEY,result);
        }
        return result;
    }

    @Override
    public List<Book> listClickRank() {
        List<Book> result = (List<Book>) cacheService.getObject(CacheKey.INDEX_CLICK_BANK_BOOK_KEY);
        if (result == null || result.size() == 0) {
            result = bookFeignClient.listRank((byte) 0, 10);
            cacheService.setObject(CacheKey.INDEX_CLICK_BANK_BOOK_KEY, result, 5000);
        }
        return result;
    }

    @Override
    public List<Book> listNewRank() {
        List<Book> result = (List<Book>) cacheService.getObject(CacheKey.INDEX_NEW_BOOK_KEY);
        if (result == null || result.size() == 0) {
            result = bookFeignClient.listRank((byte) 1, 10);
            cacheService.setObject(CacheKey.INDEX_NEW_BOOK_KEY, result, 3600);
        }
        return result;
    }

    @Override
    public List<BookVO> listUpdateRank() {
        List<BookVO> result = (List<BookVO>) cacheService.getObject(CacheKey.INDEX_UPDATE_BOOK_KEY);
        if (result == null || result.size() == 0) {
            List<Book> bookPOList = bookFeignClient.listRank((byte) 2, 23);
            result = BeanUtil.copyList(bookPOList, BookVO.class);
            cacheService.setObject(CacheKey.INDEX_UPDATE_BOOK_KEY, result, 60 * 10);
        }
        return result;
    }
}
