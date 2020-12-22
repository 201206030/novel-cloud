package com.java2nb.novel.user.entity;

import com.java2nb.novel.common.valid.AddGroup;
import com.java2nb.novel.common.valid.UpdateGroup;
import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Generated;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Date;

public class User implements Serializable {

    @Null(groups = {AddGroup.class, UpdateGroup.class})
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @NotBlank(groups = {AddGroup.class},message="手机号不能为空！")
    @Pattern(groups = {AddGroup.class},regexp="^1[3|4|5|6|7|8|9][0-9]{9}$",message="手机号格式不正确！")
    @ApiModelProperty(value = "登录名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String username;

    @NotBlank(groups = {AddGroup.class},message="密码不能为空！")
    @Null(groups = {UpdateGroup.class})
    @ApiModelProperty(value = "登录密码")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String password;

    @Null(groups = {AddGroup.class})
    @ApiModelProperty(value = "昵称")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String nickName;

    @Null(groups = {AddGroup.class})
    @ApiModelProperty(value = "用户头像")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String userPhoto;

    @Null(groups = {AddGroup.class})
    @Min(value = 0,groups = {UpdateGroup.class})
    @Max(value = 1,groups = {UpdateGroup.class})
    @ApiModelProperty(value = "用户性别，0：男，1：女")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte userSex;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "账户余额")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long accountBalance;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "用户状态，0：正常")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte status;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "创建时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Null(groups = {AddGroup.class,UpdateGroup.class})
    @ApiModelProperty(value = "更新时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUsername() {
        return username;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPassword() {
        return password;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getNickName() {
        return nickName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getUserPhoto() {
        return userPhoto;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserPhoto(String userPhoto) {
        this.userPhoto = userPhoto == null ? null : userPhoto.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getUserSex() {
        return userSex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getAccountBalance() {
        return accountBalance;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAccountBalance(Long accountBalance) {
        this.accountBalance = accountBalance;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Byte status) {
        this.status = status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCreateTime() {
        return createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}