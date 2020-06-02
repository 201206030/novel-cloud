package com.java2nb.novel.search.schedule;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.common.cache.CacheKey;
import com.java2nb.novel.common.cache.CacheService;
import com.java2nb.novel.search.feign.BookFeignClient;
import com.java2nb.novel.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 小说数据导入搜索引擎定时任务
 *
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class BookToEsSchedule {

    private final BookFeignClient bookFeignClient;

    private final CacheService cacheService;


    private final SearchService searchService;

    private final RedissonClient redissonClient;


    /**
     * 1分钟导入一次
     */
    @Scheduled(fixedRate = 1000 * 60)
    public void saveToEs() {
        RLock lock = redissonClient.getLock("saveToEs");
        lock.lock();

        try {
            //查询需要更新的小说
            Date lastDate = (Date) cacheService.getObject(CacheKey.ES_LAST_UPDATE_TIME);
            if (lastDate == null) {
                lastDate = new SimpleDateFormat("yyyy-MM-dd").parse("2020-01-01");
            }


            List<Book> books = bookFeignClient.queryBookByMinUpdateTime(lastDate, 100);
            for (Book book : books) {
                searchService.importToEs(book);
                lastDate = book.getUpdateTime();
                Thread.sleep(5000);

            }


            cacheService.setObject(CacheKey.ES_LAST_UPDATE_TIME, lastDate);

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
        lock.unlock();


    }




}
