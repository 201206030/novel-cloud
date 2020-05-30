package com.java2nb.novel.news.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java2nb.novel.news.entity.News;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 新闻VO对象
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@Data
public class NewsVO extends News {

    @ApiModelProperty(value = "新闻发布时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date createTime;
}
