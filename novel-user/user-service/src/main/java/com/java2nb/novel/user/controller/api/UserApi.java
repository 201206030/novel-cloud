package com.java2nb.novel.user.controller.api;


import com.java2nb.novel.user.entity.User;
import com.java2nb.novel.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

/**
 * 用户微服务API接口（内部调用）
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
@ApiIgnore
public class UserApi {

    private final UserService userService;


    /**
     * 根据用户名密码查询记录
     * */
    @GetMapping("queryByUsernameAndPassword")
    public User queryByUsernameAndPassword(String username, String password){
        return userService.queryByUsernameAndPassword(username,password);

    }





}
