package com.java2nb.novel.search.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import springfox.documentation.annotations.ApiIgnore;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 封装页面搜索参数
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@Data
public class SearchParamVO {

    @ApiModelProperty("搜索关键字")
    private String keyword;

    @ApiModelProperty("作品方向")
    private Byte workDirection;

    @ApiModelProperty("分类ID")
    private Integer catId;

    @ApiModelProperty("是否收费，1：收费，0：免费")
    private Byte isVip;

    @ApiModelProperty("小说更新状态，0：连载中，1：已完结")
    private Byte bookStatus;

    @ApiModelProperty("字数最小值")
    private Integer wordCountMin;

    @ApiModelProperty("字数最大值")
    private Integer wordCountMax;

    @ApiModelProperty(hidden = true)
    private Date updateTimeMin;

    @ApiModelProperty("更新时间（单位：天）")
    private Long updatePeriod;

    @ApiModelProperty("排序字段")
    private String sort;



}
