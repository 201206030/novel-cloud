package com.java2nb.novel.user.entity;

import io.swagger.annotations.ApiModelProperty;

import javax.annotation.Generated;
import java.util.Date;

public class UserPayRecord {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "充值用户ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @ApiModelProperty(value = "充值方式，1：支付宝，2：微信")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte payChannel;

    @ApiModelProperty(value = "商户订单号")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long outTradeNo;

    @ApiModelProperty(value = "充值金额(单位元)")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer totalAmount;

    @ApiModelProperty(value = "获得屋币")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer wuAmount;

    @ApiModelProperty(value = "充值时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date payTime;

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
    public Byte getPayChannel() {
        return payChannel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPayChannel(Byte payChannel) {
        this.payChannel = payChannel;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Long getOutTradeNo() {
        return outTradeNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOutTradeNo(Long outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getTotalAmount() {
        return totalAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Integer getWuAmount() {
        return wuAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setWuAmount(Integer wuAmount) {
        this.wuAmount = wuAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Date getPayTime() {
        return payTime;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPayTime(Date payTime) {
        this.payTime = payTime;
    }
}