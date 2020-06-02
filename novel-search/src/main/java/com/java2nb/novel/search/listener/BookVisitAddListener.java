package com.java2nb.novel.search.listener;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.common.cache.CacheKey;
import com.java2nb.novel.common.cache.CacheService;
import com.java2nb.novel.search.feign.BookFeignClient;
import com.java2nb.novel.search.service.SearchService;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;


/**
 * 消息监听器
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/6/2
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class BookVisitAddListener {


    private final CacheService cacheService;

    private final SearchService searchService;

   private final RedissonClient redissonClient;

   private final BookFeignClient bookFeignClient;





    /**
     * 更新搜索引擎
     * 流量削峰，每本小说1个小时更新一次
     */
    @RabbitListener(queues = {"UPDATE-ES-QUEUE"})
    public void updateEs(Long bookId, Channel channel, Message message) {

        log.debug("收到更新搜索引擎消息：" + bookId);
        RLock lock = redissonClient.getLock("addVisitCountToEs");
        lock.lock();
        if (cacheService.get(CacheKey.ES_IS_UPDATE_VISIT + bookId) == null) {
            cacheService.set(CacheKey.ES_IS_UPDATE_VISIT + bookId, "1", 60 * 60);
            try {
                Thread.sleep(1000 * 5);
                Book book = bookFeignClient.queryBookById(bookId);
                searchService.importToEs(book);
            }catch (Exception e){
                cacheService.del(CacheKey.ES_IS_UPDATE_VISIT + bookId);
                log.error("更新搜索引擎失败"+bookId);
            }

        }
        lock.unlock();


    }


}
