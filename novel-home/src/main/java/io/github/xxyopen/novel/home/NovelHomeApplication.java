package io.github.xxyopen.novel.home;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"io.github.xxyopen.novel"})
@MapperScan("io.github.xxyopen.novel.*.dao.mapper")
@EnableCaching
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"io.github.xxyopen.novel.book.feign"})
public class NovelHomeApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelHomeApplication.class, args);
    }

}
