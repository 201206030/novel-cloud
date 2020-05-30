package com.java2nb.novel.home.vo;

import com.java2nb.novel.home.entity.HomeBook;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 首页小说VO对象
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@Data
public class HomeBookVO extends HomeBook implements Serializable {

    @ApiModelProperty(value = "小说名")
    private String bookName;

    @ApiModelProperty(value = "小说封面")
    private String picUrl;

    @ApiModelProperty(value = "作者名")
    private String authorName;

    @ApiModelProperty(value = "小说简介")
    private String bookDesc;

    @ApiModelProperty(value = "小说评分")
    private Float score;


    @Override
    public String toString() {
        return super.toString();
    }
}
