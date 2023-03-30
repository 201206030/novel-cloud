package io.github.xxyopen.novel.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication(scanBasePackages = {"io.github.xxyopen.novel"})
@EnableDiscoveryClient
public class NovelResourceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelResourceApplication.class, args);
    }

}
