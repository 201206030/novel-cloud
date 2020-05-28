package com.java2nb.novel;

import com.java2nb.novel.common.cache.CacheService;
import com.java2nb.novel.common.cache.impl.RedisServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.autoconfigure.data.redis.RedisRepositoriesAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 小说微服务启动器
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@SpringBootApplication(exclude={
        RedisAutoConfiguration.class,
        RedisRepositoriesAutoConfiguration.class
})
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {CacheService.class})})
@EnableFeignClients
public class BookApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookApplication.class);
    }
}
