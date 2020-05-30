package com.java2nb.novel.common.bean;

import lombok.Data;

/**
 * 登陆用户信息封装
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@Data
public class UserDetails {

    private Long id;

    private String username;

    private String nickName;
}
