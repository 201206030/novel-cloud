package com.java2nb.novel.book.feign;

import com.java2nb.novel.user.api.UserApi;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * 用户服务Feign客户端
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@FeignClient("user-service")
public interface UserFeignClient extends UserApi {

}
