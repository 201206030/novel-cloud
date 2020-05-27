package com.java2nb.novel.user.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Generated;
import java.util.Date;

public class UserBuyRecord {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "用户ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @ApiModelProperty(value = "购买的小说ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long bookId;

    @ApiModelProperty(value = "购买的小说名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String bookName;

    @ApiModelProperty(value = "购买的章节ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long bookIndexId;

    @ApiModelProperty(value = "购买的章节名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String bookIndexName;

    @ApiModelProperty(value = "购买使用的屋币数量")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer buyAmount;

    @ApiModelProperty(value = "购买时间")
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
    public Long getBookId() {
        return bookId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBookName() {
        return bookName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookName(String bookName) {
        this.bookName = bookName == null ? null : bookName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getBookIndexId() {
        return bookIndexId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookIndexId(Long bookIndexId) {
        this.bookIndexId = bookIndexId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBookIndexName() {
        return bookIndexName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookIndexName(String bookIndexName) {
        this.bookIndexName = bookIndexName == null ? null : bookIndexName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getBuyAmount() {
        return buyAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBuyAmount(Integer buyAmount) {
        this.buyAmount = buyAmount;
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