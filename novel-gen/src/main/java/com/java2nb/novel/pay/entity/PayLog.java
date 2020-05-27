package com.java2nb.novel.pay.entity;

import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.annotation.Generated;

public class PayLog {
    @ApiModelProperty(value = "主键")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long id;

    @ApiModelProperty(value = "商户订单号")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long outTradeNo;

    @ApiModelProperty(value = "交易类型，0:充值购买屋币，1:包年VIP")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte tradeType;

    @ApiModelProperty(value = "支付宝/微信交易号")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String tradeNo;

    @ApiModelProperty(value = "支付渠道，1：支付宝，2：微信")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Byte payChannel;

    @ApiModelProperty(value = "交易金额(单位分)")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Integer totalAmount;

    @ApiModelProperty(value = "支付用户ID")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Long userId;

    @ApiModelProperty(value = "支付状态")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private String payStatus;

    @ApiModelProperty(value = "创建时间")
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    private Date createTime;

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
    public Long getOutTradeNo() {
        return outTradeNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setOutTradeNo(Long outTradeNo) {
        this.outTradeNo = outTradeNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public Byte getTradeType() {
        return tradeType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTradeType(Byte tradeType) {
        this.tradeType = tradeType;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public String getTradeNo() {
        return tradeNo;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo == null ? null : tradeNo.trim();
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
    public Integer getTotalAmount() {
        return totalAmount;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
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
    public String getPayStatus() {
        return payStatus;
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public void setPayStatus(String payStatus) {
        this.payStatus = payStatus == null ? null : payStatus.trim();
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