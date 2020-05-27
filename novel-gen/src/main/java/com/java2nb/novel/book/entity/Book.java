package com.java2nb.novel.book.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.annotation.Generated;

public class Book {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "作品方向，0：男频，1：女频'")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte workDirection;

    @ApiModelProperty(value = "分类ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer catId;

    @ApiModelProperty(value = "分类名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String catName;

    @ApiModelProperty(value = "小说封面")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String picUrl;

    @ApiModelProperty(value = "小说名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String bookName;

    @ApiModelProperty(value = "作者id")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long authorId;

    @ApiModelProperty(value = "作者名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String authorName;

    @ApiModelProperty(value = "书籍描述")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String bookDesc;

    @ApiModelProperty(value = "评分，预留字段")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Float score;

    @ApiModelProperty(value = "书籍状态，0：连载中，1：已完结")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte bookStatus;

    @ApiModelProperty(value = "点击量")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long visitCount;

    @ApiModelProperty(value = "总字数")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer wordCount;

    @ApiModelProperty(value = "评论数")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer commentCount;

    @ApiModelProperty(value = "最新目录ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long lastIndexId;

    @ApiModelProperty(value = "最新目录名")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String lastIndexName;

    @ApiModelProperty(value = "最新目录更新时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date lastIndexUpdateTime;

    @ApiModelProperty(value = "是否收费，1：收费，0：免费")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte isVip;

    @ApiModelProperty(value = "状态，0：入库，1：上架")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte status;

    @ApiModelProperty(value = "更新时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date updateTime;

    @ApiModelProperty(value = "创建时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

    @ApiModelProperty(value = "爬虫源站ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer crawlSourceId;

    @ApiModelProperty(value = "抓取的源站小说ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String crawlBookId;

    @ApiModelProperty(value = "最后一次的抓取时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date crawlLastTime;

    @ApiModelProperty(value = "是否已停止更新，0：未停止，1：已停止")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte crawlIsStop;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getId() {
        return id;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setId(Long id) {
        this.id = id;
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
    public Integer getCatId() {
        return catId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCatId(Integer catId) {
        this.catId = catId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCatName() {
        return catName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCatName(String catName) {
        this.catName = catName == null ? null : catName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getPicUrl() {
        return picUrl;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl == null ? null : picUrl.trim();
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
    public Long getAuthorId() {
        return authorId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAuthorId(Long authorId) {
        this.authorId = authorId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getAuthorName() {
        return authorName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setAuthorName(String authorName) {
        this.authorName = authorName == null ? null : authorName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getBookDesc() {
        return bookDesc;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookDesc(String bookDesc) {
        this.bookDesc = bookDesc == null ? null : bookDesc.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Float getScore() {
        return score;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setScore(Float score) {
        this.score = score;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getBookStatus() {
        return bookStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setBookStatus(Byte bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getVisitCount() {
        return visitCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setVisitCount(Long visitCount) {
        this.visitCount = visitCount;
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
    public Integer getCommentCount() {
        return commentCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getLastIndexId() {
        return lastIndexId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastIndexId(Long lastIndexId) {
        this.lastIndexId = lastIndexId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getLastIndexName() {
        return lastIndexName;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastIndexName(String lastIndexName) {
        this.lastIndexName = lastIndexName == null ? null : lastIndexName.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getLastIndexUpdateTime() {
        return lastIndexUpdateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setLastIndexUpdateTime(Date lastIndexUpdateTime) {
        this.lastIndexUpdateTime = lastIndexUpdateTime;
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
    public Byte getStatus() {
        return status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setStatus(Byte status) {
        this.status = status;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getUpdateTime() {
        return updateTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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
    public Integer getCrawlSourceId() {
        return crawlSourceId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCrawlSourceId(Integer crawlSourceId) {
        this.crawlSourceId = crawlSourceId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getCrawlBookId() {
        return crawlBookId;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCrawlBookId(String crawlBookId) {
        this.crawlBookId = crawlBookId == null ? null : crawlBookId.trim();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getCrawlLastTime() {
        return crawlLastTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCrawlLastTime(Date crawlLastTime) {
        this.crawlLastTime = crawlLastTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getCrawlIsStop() {
        return crawlIsStop;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setCrawlIsStop(Byte crawlIsStop) {
        this.crawlIsStop = crawlIsStop;
    }
}