package com.java2nb.novel.file.schedule;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.common.utils.Constants;
import com.java2nb.novel.common.utils.FileUtil;
import com.java2nb.novel.file.feign.BookFeignClient;
import com.java2nb.novel.file.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;


/**
 * 将爬取的网络图片转存到OSS任务
 *
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/6/2
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CrawlPicTransSchedule {

    private final BookFeignClient bookFeignClient;

    private final RedissonClient redissonClient;

    private final FileService fileService;


    /**
     * 10分钟转一次
     */
    @Scheduled(fixedRate = 1000 * 60 * 10)
    @SneakyThrows
    public void trans() {

        RLock lock = redissonClient.getLock("crawlPicTrans");
        lock.lock();

        try {

            List<Book> networkPicBooks = bookFeignClient.queryNetworkPicBooks(Constants.LOCAL_PIC_PREFIX, 100);
            for (Book book : networkPicBooks) {

                String filePath = "/images/default.gif";
                File file = FileUtil.networkPic2Temp(book.getPicUrl());
                if (file != null) {

                    filePath = fileService.uploadFile(file);


                }


                bookFeignClient.updateBookPic(filePath, book.getId());
                //3秒钟转化一张图片，10分钟转化200张
                Thread.sleep(3000);
            }

        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }

        lock.unlock();


    }
}
