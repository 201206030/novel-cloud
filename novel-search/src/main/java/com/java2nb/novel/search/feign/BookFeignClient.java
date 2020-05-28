package com.java2nb.novel.search.feign;


import com.java2nb.novel.book.api.BookApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 小说服务Feign客户端
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@FeignClient(value = "book-service")
public interface BookFeignClient extends BookApi {


}
