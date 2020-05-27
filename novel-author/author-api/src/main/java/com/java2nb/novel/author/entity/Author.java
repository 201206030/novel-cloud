package com.java2nb.novel.author.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Generated;
import java.util.Date;

public class Author {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @ApiModelProperty(value = "邀请码")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String inviteCode;

    @ApiModelProperty(value = "笔名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String penName;

    @ApiModelProperty(value = "手机号码")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String telPhone;

    @ApiModelProperty(value = "QQ或微信账号")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String chatAccount;

    @ApiModelProperty(value = "电子邮箱")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String email;

    @ApiModelProperty(value = "作品方向，0：男频，1：女频")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte workDirection;

    @ApiModelProperty(value = "0：正常，1：封禁")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte status;

    @ApiModelProperty(value = "创建时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getUserId() {
        return userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getInviteCode() {
        return inviteCode;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode == null ? null : inviteCode.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPenName() {
        return penName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPenName(String penName) {
        this.penName = penName == null ? null : penName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTelPhone() {
        return telPhone;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTelPhone(String telPhone) {
        this.telPhone = telPhone == null ? null : telPhone.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getChatAccount() {
        return chatAccount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setChatAccount(String chatAccount) {
        this.chatAccount = chatAccount == null ? null : chatAccount.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getEmail() {
        return email;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getWorkDirection() {
        return workDirection;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWorkDirection(Byte workDirection) {
        this.workDirection = workDirection;
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
}