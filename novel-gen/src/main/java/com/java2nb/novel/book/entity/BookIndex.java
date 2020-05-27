package com.java2nb.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.annotation.Generated;

public class BookIndex {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "小说ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long bookId;

    @ApiModelProperty(value = "目录号")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer indexNum;

    @ApiModelProperty(value = "目录名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String indexName;

    @ApiModelProperty(value = "字数")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer wordCount;

    @ApiModelProperty(value = "是否收费，1：收费，0：免费")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte isVip;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

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
    public Long getBookId() {
        return bookId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookId(Long bookId) {
        this.bookId = bookId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getIndexNum() {
        return indexNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIndexNum(Integer indexNum) {
        this.indexNum = indexNum;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getIndexName() {
        return indexName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIndexName(String indexName) {
        this.indexName = indexName == null ? null : indexName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWordCount() {
        return wordCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWordCount(Integer wordCount) {
        this.wordCount = wordCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getIsVip() {
        return isVip;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setIsVip(Byte isVip) {
        this.isVip = isVip;
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