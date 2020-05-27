package com.java2nb.novel.author.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.annotation.Generated;

public class AuthorCode {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "邀请码")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String inviteCode;

    @ApiModelProperty(value = "有效时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date validityTime;

    @ApiModelProperty(value = "是否使用过，0：未使用，1:使用过")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte isUse;

    @ApiModelProperty(value = "创建时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @ApiModelProperty(value = "创建人ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long createUserId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
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
    public Date getValidityTime() {
        return validityTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setValidityTime(Date validityTime) {
        this.validityTime = validityTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getIsUse() {
        return isUse;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsUse(Byte isUse) {
        this.isUse = isUse;
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
    public Long getCreateUserId() {
        return createUserId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }
}