package com.java2nb.novel.user.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java2nb.novel.user.entity.UserReadHistory;
import lombok.Data;

import java.util.Date;

/**
 * 小说阅读记录VO对象
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@Data
public class BookReadHistoryVO extends UserReadHistory {

    private Integer catId;
    private String catName;
    private Long lastIndexId;

    private String lastIndexName;
    private String bookName;

    @JsonFormat(timezone = "GMT+8", pattern = "MM/dd HH:mm:ss")
    private Date lastIndexUpdateTime;


    @Override
    public String toString() {
        return super.toString();
    }
}
