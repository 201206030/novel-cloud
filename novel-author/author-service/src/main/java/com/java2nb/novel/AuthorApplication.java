package com.java2nb.novel;

import com.java2nb.novel.common.cache.CacheService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * 作家微服务启动器
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@SpringBootApplication
//@ComponentScan(excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = {CacheService.class})})
@EnableFeignClients
public class AuthorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuthorApplication.class);
    }
}
