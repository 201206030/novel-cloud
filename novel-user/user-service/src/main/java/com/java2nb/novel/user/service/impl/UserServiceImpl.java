package com.java2nb.novel.user.service.impl;

import com.java2nb.novel.common.bean.UserDetails;
import com.java2nb.novel.common.enums.ResponseStatus;
import com.java2nb.novel.common.exception.BusinessException;
import com.java2nb.novel.common.utils.MD5Util;
import com.java2nb.novel.user.entity.User;
import com.java2nb.novel.user.form.UserForm;
import com.java2nb.novel.user.mapper.UserDynamicSqlSupport;
import com.java2nb.novel.user.mapper.UserMapper;
import com.java2nb.novel.user.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.Charsets;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * 小说服务接口实现
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;


    @Override
    public User queryByUsernameAndPassword(String username, String password) {

        List<User> users = userMapper.selectMany(
                select(UserDynamicSqlSupport.id, UserDynamicSqlSupport.username, UserDynamicSqlSupport.nickName)
                        .from(UserDynamicSqlSupport.user)
                        .where(UserDynamicSqlSupport.username, isEqualTo(username))
                        .and(UserDynamicSqlSupport.password, isEqualTo(MD5Util.MD5Encode(password, Charsets.UTF_8.name())))
                        .limit(1)
                        .build()
                        .render(RenderingStrategies.MYBATIS3));
        return users.size() > 0 ? users.get(0) : null;
    }

    @Override
    public UserDetails login(UserForm form) {
        //根据用户名密码查询记录
        User user = queryByUsernameAndPassword(form.getUsername(),form.getPassword());
        if (user == null) {
            throw new BusinessException(ResponseStatus.USERNAME_PASS_ERROR);
        }
        //生成UserDetail对象并返回
        UserDetails userDetails = new UserDetails();
        userDetails.setId(user.getId());
        userDetails.setNickName(user.getNickName());
        userDetails.setUsername(form.getUsername());
        return userDetails;
    }
}
