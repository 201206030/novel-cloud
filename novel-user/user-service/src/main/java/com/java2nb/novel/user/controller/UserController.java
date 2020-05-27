package com.java2nb.novel.user.controller;

import com.java2nb.novel.common.base.BaseController;
import com.java2nb.novel.common.bean.ResultBean;
import com.java2nb.novel.common.bean.UserDetails;
import com.java2nb.novel.common.enums.ResponseStatus;
import com.java2nb.novel.user.form.UserForm;
import com.java2nb.novel.user.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * @author 11797
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@EnableSwagger2
@Slf4j
@Api(tags = "用户相关接口")
public class UserController extends BaseController {



    private final UserService userService;

    /**
     * 登陆
     */
    @ApiOperation("用户登陆接口")
    @PostMapping("login")
    public ResultBean login(@Valid UserForm user, BindingResult result) {
        //判断参数是否合法
        if (result.hasErrors()) {
            log.info(result.getAllErrors().toString());
            return ResultBean.fail(ResponseStatus.PARAM_ERROR);
        }

        //登陆
        UserDetails userDetails = userService.login(user);

        Map<String, Object> data = new HashMap<>(1);
        data.put("token", jwtTokenUtil.generateToken(userDetails));

        return ResultBean.ok(data);


    }







}
