package com.java2nb.novel.user.service;


import com.java2nb.novel.common.bean.UserDetails;
import com.java2nb.novel.user.entity.User;
import com.java2nb.novel.user.form.UserForm;

/**
 * @author 11797
 */
public interface UserService {

    /**
     * 根据用户名密码查询记录
     * @param username 用户名
     * @param password 密码
     * @return 用户对象，不存在返回null
     * */
    User queryByUsernameAndPassword(String username, String password);

    /**
     * 用户登陆
     * @param form 用户登陆提交信息类
     * @return jwt载体信息类
     * */
    UserDetails login(UserForm form);


}
