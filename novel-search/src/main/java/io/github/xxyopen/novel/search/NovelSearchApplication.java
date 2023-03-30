package io.github.xxyopen.novel.search;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"io.github.xxyopen.novel"})
@EnableDiscoveryClient
@EnableFeignClients(basePackages = {"io.github.xxyopen.novel.book.feign"})
public class NovelSearchApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelSearchApplication.class, args);
    }

}
