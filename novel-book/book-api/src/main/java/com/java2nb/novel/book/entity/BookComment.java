package com.java2nb.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Date;

public class BookComment implements Serializable {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "小说ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long bookId;

    @ApiModelProperty(value = "评价内容")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String commentContent;

    @ApiModelProperty(value = "回复数量")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer replyCount;

    @ApiModelProperty(value = "审核状态，0：待审核，1：审核通过，2：审核不通过")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte auditStatus;

    @ApiModelProperty(value = "评价时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @ApiModelProperty(value = "评价人")
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
    public Long getBookId() {
        return bookId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCommentContent() {
        return commentContent;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getReplyCount() {
        return replyCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReplyCount(Integer replyCount) {
        this.replyCount = replyCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getAuditStatus() {
        return auditStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAuditStatus(Byte auditStatus) {
        this.auditStatus = auditStatus;
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