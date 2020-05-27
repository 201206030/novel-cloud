package com.java2nb.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.annotation.Generated;

public class BookCommentReply {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "评论ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long commentId;

    @ApiModelProperty(value = "回复内容")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String replyContent;

    @ApiModelProperty(value = "审核状态，0：待审核，1：审核通过，2：审核不通过")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte auditStatus;

    @ApiModelProperty(value = "回复用户ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @ApiModelProperty(value = "回复时间")
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
    public Long getCommentId() {
        return commentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getReplyContent() {
        return replyContent;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent == null ? null : replyContent.trim();
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