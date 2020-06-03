package com.java2nb.novel.news.mapper;

import com.java2nb.novel.news.entity.News;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.mybatis.dynamic.sql.delete.DeleteDSL;
import org.mybatis.dynamic.sql.delete.MyBatis3DeleteModelAdapter;
import org.mybatis.dynamic.sql.delete.render.DeleteStatementProvider;
import org.mybatis.dynamic.sql.insert.render.InsertStatementProvider;
import org.mybatis.dynamic.sql.render.RenderingStrategy;
import org.mybatis.dynamic.sql.select.MyBatis3SelectModelAdapter;
import org.mybatis.dynamic.sql.select.QueryExpressionDSL;
import org.mybatis.dynamic.sql.select.SelectDSL;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.MyBatis3UpdateModelAdapter;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.render.UpdateStatementProvider;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;

import javax.annotation.Generated;
import java.util.List;

import static com.java2nb.novel.news.mapper.NewsDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface NewsMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<News> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("NewsResult")
    News selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="NewsResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="cat_id", property="catId", jdbcType=JdbcType.INTEGER),
        @Result(column="cat_name", property="catName", jdbcType=JdbcType.VARCHAR),
        @Result(column="source_name", property="sourceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="title", property="title", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="content", property="content", jdbcType=JdbcType.VARCHAR)
    })
    List<News> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(news);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, news);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, news)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(News record) {
        return insert(SqlBuilder.insert(record)
                .into(news)
                .map(id).toProperty("id")
                .map(catId).toProperty("catId")
                .map(catName).toProperty("catName")
                .map(sourceName).toProperty("sourceName")
                .map(title).toProperty("title")
                .map(createTime).toProperty("createTime")
                .map(createUserId).toProperty("createUserId")
                .map(updateTime).toProperty("updateTime")
                .map(updateUserId).toProperty("updateUserId")
                .map(content).toProperty("content")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(News record) {
        return insert(SqlBuilder.insert(record)
                .into(news)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(catId).toPropertyWhenPresent("catId", record::getCatId)
                .map(catName).toPropertyWhenPresent("catName", record::getCatName)
                .map(sourceName).toPropertyWhenPresent("sourceName", record::getSourceName)
                .map(title).toPropertyWhenPresent("title", record::getTitle)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .map(updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
                .map(content).toPropertyWhenPresent("content", record::getContent)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<News>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, catId, catName, sourceName, title, createTime, createUserId, updateTime, updateUserId, content)
                .from(news);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<News>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, catId, catName, sourceName, title, createTime, createUserId, updateTime, updateUserId, content)
                .from(news);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default News selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, catId, catName, sourceName, title, createTime, createUserId, updateTime, updateUserId, content)
                .from(news)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(News record) {
        return UpdateDSL.updateWithMapper(this::update, news)
                .set(id).equalTo(record::getId)
                .set(catId).equalTo(record::getCatId)
                .set(catName).equalTo(record::getCatName)
                .set(sourceName).equalTo(record::getSourceName)
                .set(title).equalTo(record::getTitle)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(updateUserId).equalTo(record::getUpdateUserId)
                .set(content).equalTo(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(News record) {
        return UpdateDSL.updateWithMapper(this::update, news)
                .set(id).equalToWhenPresent(record::getId)
                .set(catId).equalToWhenPresent(record::getCatId)
                .set(catName).equalToWhenPresent(record::getCatName)
                .set(sourceName).equalToWhenPresent(record::getSourceName)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(content).equalToWhenPresent(record::getContent);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(News record) {
        return UpdateDSL.updateWithMapper(this::update, news)
                .set(catId).equalTo(record::getCatId)
                .set(catName).equalTo(record::getCatName)
                .set(sourceName).equalTo(record::getSourceName)
                .set(title).equalTo(record::getTitle)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId)
                .set(updateTime).equalTo(record::getUpdateTime)
                .set(updateUserId).equalTo(record::getUpdateUserId)
                .set(content).equalTo(record::getContent)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(News record) {
        return UpdateDSL.updateWithMapper(this::update, news)
                .set(catId).equalToWhenPresent(record::getCatId)
                .set(catName).equalToWhenPresent(record::getCatName)
                .set(sourceName).equalToWhenPresent(record::getSourceName)
                .set(title).equalToWhenPresent(record::getTitle)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .set(updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(content).equalToWhenPresent(record::getContent)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}