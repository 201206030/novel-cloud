package com.java2nb.novel.user.controller;

import com.github.pagehelper.PageInfo;
import com.java2nb.novel.book.entity.BookComment;
import com.java2nb.novel.common.base.BaseController;
import com.java2nb.novel.common.bean.PageBean;
import com.java2nb.novel.common.bean.ResultBean;
import com.java2nb.novel.common.bean.UserDetails;
import com.java2nb.novel.common.cache.CacheService;
import com.java2nb.novel.common.enums.ResponseStatus;
import com.java2nb.novel.common.utils.RandomValidateCodeUtil;
import com.java2nb.novel.user.entity.User;
import com.java2nb.novel.user.entity.UserFeedback;
import com.java2nb.novel.user.feign.BookFeignClient;
import com.java2nb.novel.user.form.UserForm;
import com.java2nb.novel.user.service.UserService;
import com.java2nb.novel.user.vo.BookReadHistoryVO;
import com.java2nb.novel.user.vo.BookShelfVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户微服务Controller
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "用户相关接口")
public class UserController extends BaseController {


    private final CacheService cacheService;

    private final UserService userService;

    private final BookFeignClient bookFeignClient;

    /**
     * 登陆
     */
    @ApiOperation("用户登陆接口")
    @GetMapping("login")
    public ResultBean<Map<String, Object>> login(@Valid UserForm user, BindingResult result) {
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

    /**
     * 注册
     */
    @ApiOperation("用户注册接口")
    @PostMapping("register")
    public ResultBean<Map<String, Object>> register(@Valid UserForm user, @RequestParam(value = "velCode", defaultValue = "") String velCode, BindingResult result) {

        //判断参数是否合法
        if (result.hasErrors()) {
            log.info(result.getAllErrors().toString());
            return ResultBean.fail(ResponseStatus.PARAM_ERROR);
        }

        //判断验证码是否正确
        if (!velCode.equals(cacheService.get(RandomValidateCodeUtil.RANDOM_CODE_KEY))) {
            return ResultBean.fail(ResponseStatus.VEL_CODE_ERROR);
        }

        //注册
        UserDetails userDetails = userService.register(user);
        Map<String, Object> data = new HashMap<>(1);
        data.put("token", jwtTokenUtil.generateToken(userDetails));

        return ResultBean.ok(data);


    }

    /**
     * 刷新token
     */
    @ApiOperation("token刷新接口")
    @PostMapping("refreshToken")
    public ResultBean<Map<String, Object>> refreshToken(HttpServletRequest request) {
        String token = getToken(request);
        if (jwtTokenUtil.canRefresh(token)) {
            token = jwtTokenUtil.refreshToken(token);
            Map<String, Object> data = new HashMap<>(2);
            data.put("token", token);
            UserDetails userDetail = jwtTokenUtil.getUserDetailsFromToken(token);
            data.put("username", userDetail.getUsername());
            data.put("nickName", userDetail.getNickName());
            return ResultBean.ok(data);

        } else {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }

    }

    /**
     * 查询小说是否已加入书架
     */
    @ApiOperation("小说加入书架状态查询接口")
    @GetMapping("queryIsInShelf")
    public ResultBean queryIsInShelf(Long bookId, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        return ResultBean.ok(userService.queryIsInShelf(userDetails.getId(), bookId));
    }

    /**
     * 加入书架
     * */
    @ApiOperation("小说加入书架接口")
    @PostMapping("addToBookShelf")
    public ResultBean addToBookShelf(Long bookId,Long preContentId, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        userService.addToBookShelf(userDetails.getId(),bookId,preContentId);
        return ResultBean.ok();
    }

    /**
     * 移出书架
     * */
    @ApiOperation("小说移出书架接口")
    @DeleteMapping("removeFromBookShelf")
    public ResultBean removeFromBookShelf(Long bookId, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        userService.removeFromBookShelf(userDetails.getId(),bookId);
        return ResultBean.ok();
    }

    /**
     * 分页查询书架
     * */
    @ApiOperation("书架列表分页查询接口")
    @GetMapping("listBookShelfByPage")
    public ResultBean<PageBean<BookShelfVO>> listBookShelfByPage(@RequestParam(value = "curr", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "10") int pageSize, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        return ResultBean.ok(new PageBean<>(userService.listBookShelfByPage(userDetails.getId(),page,pageSize)));
    }

    /**
     * 分页查询阅读记录
     * */
    @ApiOperation("阅读记录分页查询接口")
    @GetMapping("listReadHistoryByPage")
    public ResultBean<PageBean<BookReadHistoryVO>> listReadHistoryByPage(@RequestParam(value = "curr", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "10") int pageSize, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        return ResultBean.ok(new PageBean<>(userService.listReadHistoryByPage(userDetails.getId(),page,pageSize)));
    }

    /**
     * 添加阅读记录
     * */
    @ApiOperation("阅读记录添加接口")
    @PostMapping("addReadHistory")
    public ResultBean addReadHistory(Long bookId,Long preContentId, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        userService.addReadHistory(userDetails.getId(),bookId,preContentId);
        return ResultBean.ok();
    }

    /**
     * 添加反馈
     * */
    @ApiOperation("反馈添加接口")
    @PostMapping("addFeedBack")
    public ResultBean addFeedBack(String content, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        userService.addFeedBack(userDetails.getId(),content);
        return ResultBean.ok();
    }

    /**
     * 分页查询我的反馈列表
     * */
    @ApiOperation("反馈列表分页查询接口")
    @GetMapping("listUserFeedBackByPage")
    public ResultBean<PageBean<UserFeedback>> listUserFeedBackByPage(@RequestParam(value = "curr", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "5") int pageSize, HttpServletRequest request){
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        return ResultBean.ok(new PageBean<>(userService.listUserFeedBackByPage(userDetails.getId(),page,pageSize)));
    }


    /**
     * 查询个人信息
     * */
    @ApiOperation("人信息查询接口")
    @GetMapping("userInfo")
    public ResultBean<User> userInfo(HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        return ResultBean.ok(userService.userInfo(userDetails.getId()));
    }


    /**
     * 更新个人信息
     * */
    @ApiOperation("人信息更新接口")
    @PostMapping("updateUserInfo")
    public ResultBean updateUserInfo(User user, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        userService.updateUserInfo(userDetails.getId(),user);
        if(user.getNickName() != null){
            userDetails.setNickName(user.getNickName());
            Map<String, Object> data = new HashMap<>(1);
            data.put("token", jwtTokenUtil.generateToken(userDetails));
            return ResultBean.ok(data);
        }
        return ResultBean.ok();
    }

    /**
     * 更新密码
     * */
    @ApiOperation("更新密码接口")
    @PostMapping("updatePassword")
    public ResultBean updatePassword(String oldPassword,String newPassword1,String newPassword2,HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        if(!(StringUtils.isNotBlank(newPassword1) && newPassword1.equals(newPassword2))){
            ResultBean.fail(ResponseStatus.TWO_PASSWORD_DIFF);
        }
        userService.updatePassword(userDetails.getId(),oldPassword,newPassword1);
        return ResultBean.ok();
    }

    /**
     * 发布评价
     * */
    @ApiOperation("发布评价接口")
    @PostMapping("addBookComment")
    public ResultBean addBookComment(BookComment comment, HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        bookFeignClient.addBookComment(userDetails.getId(),comment);
        return ResultBean.ok();
    }

    /**
     * 用户书评分页查询
     * */
    @ApiOperation("用户书评分页查询接口")
    @GetMapping("listCommentByPage")
    public ResultBean<PageBean<BookComment>> listCommentByPage(@RequestParam(value = "curr", defaultValue = "1") int page, @RequestParam(value = "limit", defaultValue = "5") int pageSize,HttpServletRequest request) {
        UserDetails userDetails = getUserDetails(request);
        if (userDetails == null) {
            return ResultBean.fail(ResponseStatus.NO_LOGIN);
        }
        return ResultBean.ok(new PageBean<>(bookFeignClient.listUserCommentByPage(userDetails.getId(),page,pageSize)));
    }




}
