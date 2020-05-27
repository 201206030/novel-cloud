package com.java2nb.novel.common.bean;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分装通用分页数据,接收PageHelper、SpringData等框架的分页数据，转换成通用的PageBean对象
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/23
 * @param <T> 分页集合类型
 */
@Data
public class PageBean<T> {

    @ApiModelProperty(value = "页码")
    private Integer pageNum;
    @ApiModelProperty(value = "每页大小")
    private Integer pageSize;
    @ApiModelProperty(value = "总页数")
    private Integer totalPage;
    @ApiModelProperty(value = "总记录数")
    private Long total;
    @ApiModelProperty(value = "分页数据集合")
    private List<T> list;


    /**
     * 接收PageHelper分页后的list
     */
    public PageBean(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.totalPage = pageInfo.getPages();
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();

    }

}
