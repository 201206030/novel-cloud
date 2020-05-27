package com.java2nb.novel.author.mapper;

import com.java2nb.novel.author.entity.AuthorCode;
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

import static com.java2nb.novel.author.mapper.AuthorCodeDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface AuthorCodeMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<AuthorCode> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AuthorCodeResult")
    AuthorCode selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AuthorCodeResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="invite_code", property="inviteCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="validity_time", property="validityTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="is_use", property="isUse", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT)
    })
    List<AuthorCode> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(authorCode);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, authorCode);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, authorCode)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(AuthorCode record) {
        return insert(SqlBuilder.insert(record)
                .into(authorCode)
                .map(id).toProperty("id")
                .map(inviteCode).toProperty("inviteCode")
                .map(validityTime).toProperty("validityTime")
                .map(isUse).toProperty("isUse")
                .map(createTime).toProperty("createTime")
                .map(createUserId).toProperty("createUserId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(AuthorCode record) {
        return insert(SqlBuilder.insert(record)
                .into(authorCode)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(inviteCode).toPropertyWhenPresent("inviteCode", record::getInviteCode)
                .map(validityTime).toPropertyWhenPresent("validityTime", record::getValidityTime)
                .map(isUse).toPropertyWhenPresent("isUse", record::getIsUse)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<AuthorCode>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, inviteCode, validityTime, isUse, createTime, createUserId)
                .from(authorCode);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<AuthorCode>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, inviteCode, validityTime, isUse, createTime, createUserId)
                .from(authorCode);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default AuthorCode selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, inviteCode, validityTime, isUse, createTime, createUserId)
                .from(authorCode)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(AuthorCode record) {
        return UpdateDSL.updateWithMapper(this::update, authorCode)
                .set(id).equalTo(record::getId)
                .set(inviteCode).equalTo(record::getInviteCode)
                .set(validityTime).equalTo(record::getValidityTime)
                .set(isUse).equalTo(record::getIsUse)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(AuthorCode record) {
        return UpdateDSL.updateWithMapper(this::update, authorCode)
                .set(id).equalToWhenPresent(record::getId)
                .set(inviteCode).equalToWhenPresent(record::getInviteCode)
                .set(validityTime).equalToWhenPresent(record::getValidityTime)
                .set(isUse).equalToWhenPresent(record::getIsUse)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(AuthorCode record) {
        return UpdateDSL.updateWithMapper(this::update, authorCode)
                .set(inviteCode).equalTo(record::getInviteCode)
                .set(validityTime).equalTo(record::getValidityTime)
                .set(isUse).equalTo(record::getIsUse)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(AuthorCode record) {
        return UpdateDSL.updateWithMapper(this::update, authorCode)
                .set(inviteCode).equalToWhenPresent(record::getInviteCode)
                .set(validityTime).equalToWhenPresent(record::getValidityTime)
                .set(isUse).equalToWhenPresent(record::getIsUse)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}