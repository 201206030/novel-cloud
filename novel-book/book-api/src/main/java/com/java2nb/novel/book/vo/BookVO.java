package com.java2nb.novel.book.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java2nb.novel.book.entity.Book;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Administrator
 */
@Data
public class BookVO extends Book{

    @ApiModelProperty(value = "最新目录更新时间")
    @JsonFormat(timezone = "GMT+8", pattern = "MM/dd HH:mm")
    private Date lastIndexUpdateTime;


}
