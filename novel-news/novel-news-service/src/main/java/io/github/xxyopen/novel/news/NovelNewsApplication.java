package io.github.xxyopen.novel.news;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication(scanBasePackages = {"io.github.xxyopen.novel"})
@MapperScan("io.github.xxyopen.novel.news.dao.mapper")
@EnableCaching
@EnableDiscoveryClient
public class NovelNewsApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelNewsApplication.class, args);
    }

}
