package com.java2nb.novel.common.bean;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * 分装通用分页数据,接收PageHelper、SpringData等框架的分页数据，转换成通用的PageBean对象
 * @author xiongxiaoyang
 * @version 1.1
 * @since 2021/4/1
 * @param <T> 分页集合类型
 */
@Data
public class PageBean<T> {

    @ApiModelProperty(value = "页码")
    private Integer pageNum;
    @ApiModelProperty(value = "每页大小")
    private Integer pageSize;
    @ApiModelProperty(value = "总记录数")
    private Long total;
    @ApiModelProperty(value = "分页数据集合")
    private List<? extends T> list;


    /**
     * 该构造函数用于PageHelper工具进行分页查询的场景
     * 接收PageHelper分页后的list
     */
    public PageBean(List<T> list){
        PageInfo<T> pageInfo = new PageInfo<>(list);
        this.pageNum = pageInfo.getPageNum();
        this.pageSize = pageInfo.getPageSize();
        this.total = pageInfo.getTotal();
        this.list = pageInfo.getList();

    }

    /**
     * 该构造函数用于通用分页查询的场景
     * 接收普通分页数据和普通集合
     */
    public PageBean(Integer pageNum, Integer pageSize, Long total, List<T> list) {
        this.pageNum = pageNum;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
    }


    //TODO 使用其他的分页工具或框架进行分页查询的场景

}
