package com.java2nb.novel.book.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java2nb.novel.book.entity.BookComment;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * 小说评论VO对象
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@Data
public class BookCommentVO extends BookComment {

    private String createUserName;

    private String createUserPhoto;

    @ApiModelProperty(value = "评价时间")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    @Override
    public String toString() {
        return super.toString();
    }
}
