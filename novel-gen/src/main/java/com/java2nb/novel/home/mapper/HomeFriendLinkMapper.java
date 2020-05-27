package com.java2nb.novel.home.mapper;

import static com.java2nb.novel.home.mapper.HomeFriendLinkDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.home.entity.HomeFriendLink;
import java.util.List;
import javax.annotation.Generated;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;
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

@Mapper
public interface HomeFriendLinkMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<HomeFriendLink> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("HomeFriendLinkResult")
    HomeFriendLink selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="HomeFriendLinkResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="link_name", property="linkName", jdbcType=JdbcType.VARCHAR),
        @Result(column="link_url", property="linkUrl", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="is_open", property="isOpen", jdbcType=JdbcType.TINYINT),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<HomeFriendLink> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, homeFriendLink)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(HomeFriendLink record) {
        return insert(SqlBuilder.insert(record)
                .into(homeFriendLink)
                .map(id).toProperty("id")
                .map(linkName).toProperty("linkName")
                .map(linkUrl).toProperty("linkUrl")
                .map(sort).toProperty("sort")
                .map(isOpen).toProperty("isOpen")
                .map(createUserId).toProperty("createUserId")
                .map(createTime).toProperty("createTime")
                .map(updateUserId).toProperty("updateUserId")
                .map(updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(HomeFriendLink record) {
        return insert(SqlBuilder.insert(record)
                .into(homeFriendLink)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(linkName).toPropertyWhenPresent("linkName", record::getLinkName)
                .map(linkUrl).toPropertyWhenPresent("linkUrl", record::getLinkUrl)
                .map(sort).toPropertyWhenPresent("sort", record::getSort)
                .map(isOpen).toPropertyWhenPresent("isOpen", record::getIsOpen)
                .map(createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
                .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<HomeFriendLink>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, linkName, linkUrl, sort, isOpen, createUserId, createTime, updateUserId, updateTime)
                .from(homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<HomeFriendLink>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, linkName, linkUrl, sort, isOpen, createUserId, createTime, updateUserId, updateTime)
                .from(homeFriendLink);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default HomeFriendLink selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, linkName, linkUrl, sort, isOpen, createUserId, createTime, updateUserId, updateTime)
                .from(homeFriendLink)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, homeFriendLink)
                .set(id).equalTo(record::getId)
                .set(linkName).equalTo(record::getLinkName)
                .set(linkUrl).equalTo(record::getLinkUrl)
                .set(sort).equalTo(record::getSort)
                .set(isOpen).equalTo(record::getIsOpen)
                .set(createUserId).equalTo(record::getCreateUserId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateUserId).equalTo(record::getUpdateUserId)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, homeFriendLink)
                .set(id).equalToWhenPresent(record::getId)
                .set(linkName).equalToWhenPresent(record::getLinkName)
                .set(linkUrl).equalToWhenPresent(record::getLinkUrl)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(isOpen).equalToWhenPresent(record::getIsOpen)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, homeFriendLink)
                .set(linkName).equalTo(record::getLinkName)
                .set(linkUrl).equalTo(record::getLinkUrl)
                .set(sort).equalTo(record::getSort)
                .set(isOpen).equalTo(record::getIsOpen)
                .set(createUserId).equalTo(record::getCreateUserId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateUserId).equalTo(record::getUpdateUserId)
                .set(updateTime).equalTo(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(HomeFriendLink record) {
        return UpdateDSL.updateWithMapper(this::update, homeFriendLink)
                .set(linkName).equalToWhenPresent(record::getLinkName)
                .set(linkUrl).equalToWhenPresent(record::getLinkUrl)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(isOpen).equalToWhenPresent(record::getIsOpen)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}