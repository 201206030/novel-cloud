package com.java2nb.novel.home.feign;

import com.java2nb.novel.book.api.BookApi;
import com.java2nb.novel.home.feign.fallback.BookFeignFallback;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 小说服务Feign客户端
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */

@FeignClient(name = "book-service",fallback = BookFeignFallback.class)
public interface BookFeignClient extends BookApi {


}
