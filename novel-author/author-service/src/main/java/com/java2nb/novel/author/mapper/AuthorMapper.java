package com.java2nb.novel.author.mapper;

import com.java2nb.novel.author.entity.Author;
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

import static com.java2nb.novel.author.mapper.AuthorDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;

@Mapper
public interface AuthorMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<Author> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AuthorResult")
    Author selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AuthorResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="invite_code", property="inviteCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="pen_name", property="penName", jdbcType=JdbcType.VARCHAR),
        @Result(column="tel_phone", property="telPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="chat_account", property="chatAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="email", property="email", jdbcType=JdbcType.VARCHAR),
        @Result(column="work_direction", property="workDirection", jdbcType=JdbcType.TINYINT),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Author> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(author);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, author);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, author)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(Author record) {
        return insert(SqlBuilder.insert(record)
                .into(author)
                .map(id).toProperty("id")
                .map(userId).toProperty("userId")
                .map(inviteCode).toProperty("inviteCode")
                .map(penName).toProperty("penName")
                .map(telPhone).toProperty("telPhone")
                .map(chatAccount).toProperty("chatAccount")
                .map(email).toProperty("email")
                .map(workDirection).toProperty("workDirection")
                .map(status).toProperty("status")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(Author record) {
        return insert(SqlBuilder.insert(record)
                .into(author)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(inviteCode).toPropertyWhenPresent("inviteCode", record::getInviteCode)
                .map(penName).toPropertyWhenPresent("penName", record::getPenName)
                .map(telPhone).toPropertyWhenPresent("telPhone", record::getTelPhone)
                .map(chatAccount).toPropertyWhenPresent("chatAccount", record::getChatAccount)
                .map(email).toPropertyWhenPresent("email", record::getEmail)
                .map(workDirection).toPropertyWhenPresent("workDirection", record::getWorkDirection)
                .map(status).toPropertyWhenPresent("status", record::getStatus)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Author>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, userId, inviteCode, penName, telPhone, chatAccount, email, workDirection, status, createTime)
                .from(author);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<Author>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, userId, inviteCode, penName, telPhone, chatAccount, email, workDirection, status, createTime)
                .from(author);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default Author selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, userId, inviteCode, penName, telPhone, chatAccount, email, workDirection, status, createTime)
                .from(author)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(Author record) {
        return UpdateDSL.updateWithMapper(this::update, author)
                .set(id).equalTo(record::getId)
                .set(userId).equalTo(record::getUserId)
                .set(inviteCode).equalTo(record::getInviteCode)
                .set(penName).equalTo(record::getPenName)
                .set(telPhone).equalTo(record::getTelPhone)
                .set(chatAccount).equalTo(record::getChatAccount)
                .set(email).equalTo(record::getEmail)
                .set(workDirection).equalTo(record::getWorkDirection)
                .set(status).equalTo(record::getStatus)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(Author record) {
        return UpdateDSL.updateWithMapper(this::update, author)
                .set(id).equalToWhenPresent(record::getId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(inviteCode).equalToWhenPresent(record::getInviteCode)
                .set(penName).equalToWhenPresent(record::getPenName)
                .set(telPhone).equalToWhenPresent(record::getTelPhone)
                .set(chatAccount).equalToWhenPresent(record::getChatAccount)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(Author record) {
        return UpdateDSL.updateWithMapper(this::update, author)
                .set(userId).equalTo(record::getUserId)
                .set(inviteCode).equalTo(record::getInviteCode)
                .set(penName).equalTo(record::getPenName)
                .set(telPhone).equalTo(record::getTelPhone)
                .set(chatAccount).equalTo(record::getChatAccount)
                .set(email).equalTo(record::getEmail)
                .set(workDirection).equalTo(record::getWorkDirection)
                .set(status).equalTo(record::getStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(Author record) {
        return UpdateDSL.updateWithMapper(this::update, author)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(inviteCode).equalToWhenPresent(record::getInviteCode)
                .set(penName).equalToWhenPresent(record::getPenName)
                .set(telPhone).equalToWhenPresent(record::getTelPhone)
                .set(chatAccount).equalToWhenPresent(record::getChatAccount)
                .set(email).equalToWhenPresent(record::getEmail)
                .set(workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(status).equalToWhenPresent(record::getStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}