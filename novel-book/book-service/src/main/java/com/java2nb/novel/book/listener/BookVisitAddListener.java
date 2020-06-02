package com.java2nb.novel.book.listener;
import com.java2nb.novel.book.service.BookService;
import com.java2nb.novel.common.cache.CacheKey;
import com.java2nb.novel.common.cache.CacheService;
import com.java2nb.novel.common.utils.Constants;
import com.rabbitmq.client.Channel;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
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

    private final BookService bookService;

    private final CacheService cacheService;


    private final RedissonClient redissonClient;




    /**
     * 更新数据库
     * 流量削峰，每本小说累积10个点击更新一次
     */
    @SneakyThrows
    @RabbitListener(queues = {"UPDATE-DB-QUEUE"})
    public void updateDb(Long bookId, Channel channel, Message message) {

        log.debug("收到更新数据库消息：" + bookId);
        RLock lock = redissonClient.getLock("addVisitCountToDb");
        lock.lock();
        try {
            Integer visitCount = (Integer) cacheService.getObject(CacheKey.BOOK_ADD_VISIT_COUNT + bookId);
            if (visitCount == null) {
                visitCount = 0;
            }
            cacheService.setObject(CacheKey.BOOK_ADD_VISIT_COUNT + bookId, ++visitCount);
            if (visitCount >= Constants.ADD_MAX_VISIT_COUNT) {
                bookService.addVisitCount(bookId, visitCount);
                cacheService.del(CacheKey.BOOK_ADD_VISIT_COUNT + bookId);
            }
        }catch (Exception e){
            log.error("更新数据库失败"+bookId);
        }

        lock.unlock();

        Thread.sleep(1000 * 2);



    }



}
