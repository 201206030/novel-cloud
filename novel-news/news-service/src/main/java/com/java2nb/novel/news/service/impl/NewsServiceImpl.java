package com.java2nb.novel.news.service.impl;

import com.github.pagehelper.PageHelper;
import com.java2nb.novel.common.utils.BeanUtil;
import com.java2nb.novel.news.entity.News;
import com.java2nb.novel.news.mapper.NewsDynamicSqlSupport;
import com.java2nb.novel.news.mapper.NewsMapper;
import com.java2nb.novel.news.service.NewsService;
import com.java2nb.novel.news.vo.NewsVO;
import lombok.RequiredArgsConstructor;
import org.mybatis.dynamic.sql.render.RenderingStrategies;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static org.mybatis.dynamic.sql.select.SelectDSL.select;

/**
 * 新闻服务接口实现
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsMapper newsMapper;



    @Override
    public List<NewsVO> listByPage(int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        SelectStatementProvider selectStatement =
                select(NewsDynamicSqlSupport.id, NewsDynamicSqlSupport.catName,
                        NewsDynamicSqlSupport.catId, NewsDynamicSqlSupport.title,NewsDynamicSqlSupport.createTime)
                .from(NewsDynamicSqlSupport.news)
                .orderBy(NewsDynamicSqlSupport.createTime.descending())
                .build()
                .render(RenderingStrategies.MYBATIS3);

        return BeanUtil.copyList(newsMapper.selectMany(selectStatement), NewsVO.class);
    }

    @Override
    public List<News> listLastIndexNews(int limit) {
            SelectStatementProvider selectStatement =
                    select(NewsDynamicSqlSupport.id, NewsDynamicSqlSupport.catName,
                            NewsDynamicSqlSupport.catId, NewsDynamicSqlSupport.title)
                    .from(NewsDynamicSqlSupport.news)
                    .orderBy(NewsDynamicSqlSupport.createTime.descending())
                    .limit(limit)
                    .build()
                    .render(RenderingStrategies.MYBATIS3);
            return newsMapper.selectMany(selectStatement);
    }

    @Override
    public News queryNewsInfo(Long newsId) {
        SelectStatementProvider selectStatement = select(NewsDynamicSqlSupport.news.allColumns())
                .from(NewsDynamicSqlSupport.news)
                .where(NewsDynamicSqlSupport.id,isEqualTo(newsId))
                .build()
                .render(RenderingStrategies.MYBATIS3);
        return newsMapper.selectMany(selectStatement).get(0);
    }
}
