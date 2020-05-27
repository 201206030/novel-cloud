package com.java2nb.novel.user.mapper;

import static com.java2nb.novel.user.mapper.UserPayRecordDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.user.entity.UserPayRecord;
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
public interface UserPayRecordMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<UserPayRecord> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("UserPayRecordResult")
    UserPayRecord selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="UserPayRecordResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.TINYINT),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.BIGINT),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="wu_amount", property="wuAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="pay_time", property="payTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserPayRecord> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, userPayRecord)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(UserPayRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(userPayRecord)
                .map(id).toProperty("id")
                .map(userId).toProperty("userId")
                .map(payChannel).toProperty("payChannel")
                .map(outTradeNo).toProperty("outTradeNo")
                .map(totalAmount).toProperty("totalAmount")
                .map(wuAmount).toProperty("wuAmount")
                .map(payTime).toProperty("payTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(UserPayRecord record) {
        return insert(SqlBuilder.insert(record)
                .into(userPayRecord)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(payChannel).toPropertyWhenPresent("payChannel", record::getPayChannel)
                .map(outTradeNo).toPropertyWhenPresent("outTradeNo", record::getOutTradeNo)
                .map(totalAmount).toPropertyWhenPresent("totalAmount", record::getTotalAmount)
                .map(wuAmount).toPropertyWhenPresent("wuAmount", record::getWuAmount)
                .map(payTime).toPropertyWhenPresent("payTime", record::getPayTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserPayRecord>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, userId, payChannel, outTradeNo, totalAmount, wuAmount, payTime)
                .from(userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<UserPayRecord>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, userId, payChannel, outTradeNo, totalAmount, wuAmount, payTime)
                .from(userPayRecord);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UserPayRecord selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, userId, payChannel, outTradeNo, totalAmount, wuAmount, payTime)
                .from(userPayRecord)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userPayRecord)
                .set(id).equalTo(record::getId)
                .set(userId).equalTo(record::getUserId)
                .set(payChannel).equalTo(record::getPayChannel)
                .set(outTradeNo).equalTo(record::getOutTradeNo)
                .set(totalAmount).equalTo(record::getTotalAmount)
                .set(wuAmount).equalTo(record::getWuAmount)
                .set(payTime).equalTo(record::getPayTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userPayRecord)
                .set(id).equalToWhenPresent(record::getId)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(payChannel).equalToWhenPresent(record::getPayChannel)
                .set(outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(wuAmount).equalToWhenPresent(record::getWuAmount)
                .set(payTime).equalToWhenPresent(record::getPayTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userPayRecord)
                .set(userId).equalTo(record::getUserId)
                .set(payChannel).equalTo(record::getPayChannel)
                .set(outTradeNo).equalTo(record::getOutTradeNo)
                .set(totalAmount).equalTo(record::getTotalAmount)
                .set(wuAmount).equalTo(record::getWuAmount)
                .set(payTime).equalTo(record::getPayTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(UserPayRecord record) {
        return UpdateDSL.updateWithMapper(this::update, userPayRecord)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(payChannel).equalToWhenPresent(record::getPayChannel)
                .set(outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(wuAmount).equalToWhenPresent(record::getWuAmount)
                .set(payTime).equalToWhenPresent(record::getPayTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}