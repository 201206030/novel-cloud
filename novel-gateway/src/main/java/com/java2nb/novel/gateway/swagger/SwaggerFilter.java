package com.java2nb.novel.gateway.swagger;

import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
/**
 * swagger过滤器，重新设置单个微服务接口文档的路径和接口的基础请求路径
 * 如果要让网关的swagger生效，一定要在每个微服务路由配置的过滤器filters首行配置上SwaggerFilter
 * 因为filters下的过滤器按顺序执行，所以一定要注意顺序，只能放到首行
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2021/4/3
 */
@Component
public class SwaggerFilter extends AbstractGatewayFilterFactory {
    private static final String HEADER_NAME = "X-Forwarded-Prefix";

    @Override
    public GatewayFilter apply(Object config) {

        return (exchange, chain) -> {
            ServerHttpRequest request = exchange.getRequest();
            String path = request.getURI().getPath();
            if (!StringUtils.endsWithIgnoreCase(path, SwaggerProvider.API_URI)) {
                return chain.filter(exchange);
            }
            //重新设置doc文档的路径（断言先执行，不影响已经断言到的服务）
            ServerHttpRequest.Builder build = request.mutate().path("/api"+SwaggerProvider.API_URI);
            //设置接口的基础请求路径
            ServerHttpRequest newRequest = build.header(HEADER_NAME, "/api").build();
            ServerWebExchange newExchange = exchange.mutate().request(newRequest).build();
            return chain.filter(newExchange);
        };
    }
}
