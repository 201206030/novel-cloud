package com.java2nb.novel.book.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java2nb.novel.book.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 小说VO对象
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@Data
public class BookVO extends Book{

    @ApiModelProperty(value = "最新目录更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "MM/dd HH:mm")
    private Date lastIndexUpdateTime;


}
