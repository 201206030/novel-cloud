package com.java2nb.novel.user.mapper;

import static com.java2nb.novel.user.mapper.UserBuyRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.user.entity.UserBuyRecord;
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
public interface UserBuyRecordMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserBuyRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserBuyRecordResult")
    UserBuyRecord selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserBuyRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_name", property="bookName", jdbcType=JdbcType.VARCHAR),
        @Result(column="book_index_id", property="bookIndexId", jdbcType=JdbcType.BIGINT),
        @Result(column="book_index_name", property="bookIndexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="buy_amount", property="buyAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserBuyRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, userBuyRecord)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserBuyRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(userBuyRecord)
                .map(id).toProperty("id")
                .map(userId).toProperty("userId")
                .map(bookId).toProperty("bookId")
                .map(bookName).toProperty("bookName")
                .map(bookIndexId).toProperty("bookIndexId")
                .map(bookIndexName).toProperty("bookIndexName")
                .map(buyAmount).toProperty("buyAmount")
                .map(createTime).toProperty("createTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserBuyRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(userBuyRecord)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(bookId).toPropertyWhenPresent("bookId", record::getBookId)
                .map(bookName).toPropertyWhenPresent("bookName", record::getBookName)
                .map(bookIndexId).toPropertyWhenPresent("bookIndexId", record::getBookIndexId)
                .map(bookIndexName).toPropertyWhenPresent("bookIndexName", record::getBookIndexName)
                .map(buyAmount).toPropertyWhenPresent("buyAmount", record::getBuyAmount)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserBuyRecord>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, userId, bookId, bookName, bookIndexId, bookIndexName, buyAmount, createTime)
                .from(userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserBuyRecord>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, userId, bookId, bookName, bookIndexId, bookIndexName, buyAmount, createTime)
                .from(userBuyRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UserBuyRecord selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, userId, bookId, bookName, bookIndexId, bookIndexName, buyAmount, createTime)
                .from(userBuyRecord)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userBuyRecord)
                .set(id).equalTo(record::getId)
                .set(userId).equalTo(record::getUserId)
                .set(bookId).equalTo(record::getBookId)
                .set(bookName).equalTo(record::getBookName)
                .set(bookIndexId).equalTo(record::getBookIndexId)
                .set(bookIndexName).equalTo(record::getBookIndexName)
                .set(buyAmount).equalTo(record::getBuyAmount)
                .set(createTime).equalTo(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userBuyRecord)
                .set(id).equalToWhenPresent(record::getId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(bookId).equalToWhenPresent(record::getBookId)
                .set(bookName).equalToWhenPresent(record::getBookName)
                .set(bookIndexId).equalToWhenPresent(record::getBookIndexId)
                .set(bookIndexName).equalToWhenPresent(record::getBookIndexName)
                .set(buyAmount).equalToWhenPresent(record::getBuyAmount)
                .set(createTime).equalToWhenPresent(record::getCreateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userBuyRecord)
                .set(userId).equalTo(record::getUserId)
                .set(bookId).equalTo(record::getBookId)
                .set(bookName).equalTo(record::getBookName)
                .set(bookIndexId).equalTo(record::getBookIndexId)
                .set(bookIndexName).equalTo(record::getBookIndexName)
                .set(buyAmount).equalTo(record::getBuyAmount)
                .set(createTime).equalTo(record::getCreateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserBuyRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userBuyRecord)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(bookId).equalToWhenPresent(record::getBookId)
                .set(bookName).equalToWhenPresent(record::getBookName)
                .set(bookIndexId).equalToWhenPresent(record::getBookIndexId)
                .set(bookIndexName).equalToWhenPresent(record::getBookIndexName)
                .set(buyAmount).equalToWhenPresent(record::getBuyAmount)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}