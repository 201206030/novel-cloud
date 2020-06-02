package com.java2nb.novel.common.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * rabbitmq配置类
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/6/2
 */
@Configuration
@ConditionalOnProperty(prefix = "spring.rabbitmq", name = "host", matchIfMissing = false)
public class RabbitConfig {


    /**
     * 更新数据库队列
     */
    @Bean
    public Queue updateDbQueue() {
        return new Queue("UPDATE-DB-QUEUE", true);
    }

    /**
     * 更新数据库队列
     */
    @Bean
    public Queue updateEsQueue() {
        return new Queue("UPDATE-ES-QUEUE", true);
    }


    /**
     * 增加点击量交换机
     */
    @Bean
    public FanoutExchange addVisitExchange() {
        return new FanoutExchange("ADD-BOOK-VISIT-EXCHANGE");
    }

    /**
     * 更新搜索引擎队列绑定到增加点击量交换机中
     */
    @Bean
    public Binding updateEsBinding() {

        return BindingBuilder.bind(updateEsQueue()).to(addVisitExchange());
    }

    /**
     * 更新数据库绑定到增加点击量交换机中
     */
    @Bean
    public Binding updateDbBinding() {
        return BindingBuilder.bind(updateDbQueue()).to(addVisitExchange());
    }


}
