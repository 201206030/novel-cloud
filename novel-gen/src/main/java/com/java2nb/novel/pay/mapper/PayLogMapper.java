package com.java2nb.novel.pay.mapper;

import static com.java2nb.novel.pay.mapper.PayLogDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.pay.entity.PayLog;
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
public interface PayLogMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<PayLog> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("PayLogResult")
    PayLog selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="PayLogResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="out_trade_no", property="outTradeNo", jdbcType=JdbcType.BIGINT),
        @Result(column="trade_type", property="tradeType", jdbcType=JdbcType.TINYINT),
        @Result(column="trade_no", property="tradeNo", jdbcType=JdbcType.VARCHAR),
        @Result(column="pay_channel", property="payChannel", jdbcType=JdbcType.TINYINT),
        @Result(column="total_amount", property="totalAmount", jdbcType=JdbcType.INTEGER),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.BIGINT),
        @Result(column="pay_status", property="payStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PayLog> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, payLog)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(PayLog record) {
        return insert(SqlBuilder.insert(record)
                .into(payLog)
                .map(id).toProperty("id")
                .map(outTradeNo).toProperty("outTradeNo")
                .map(tradeType).toProperty("tradeType")
                .map(tradeNo).toProperty("tradeNo")
                .map(payChannel).toProperty("payChannel")
                .map(totalAmount).toProperty("totalAmount")
                .map(userId).toProperty("userId")
                .map(payStatus).toProperty("payStatus")
                .map(createTime).toProperty("createTime")
                .map(updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(PayLog record) {
        return insert(SqlBuilder.insert(record)
                .into(payLog)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(outTradeNo).toPropertyWhenPresent("outTradeNo", record::getOutTradeNo)
                .map(tradeType).toPropertyWhenPresent("tradeType", record::getTradeType)
                .map(tradeNo).toPropertyWhenPresent("tradeNo", record::getTradeNo)
                .map(payChannel).toPropertyWhenPresent("payChannel", record::getPayChannel)
                .map(totalAmount).toPropertyWhenPresent("totalAmount", record::getTotalAmount)
                .map(userId).toPropertyWhenPresent("userId", record::getUserId)
                .map(payStatus).toPropertyWhenPresent("payStatus", record::getPayStatus)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<PayLog>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, outTradeNo, tradeType, tradeNo, payChannel, totalAmount, userId, payStatus, createTime, updateTime)
                .from(payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<PayLog>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, outTradeNo, tradeType, tradeNo, payChannel, totalAmount, userId, payStatus, createTime, updateTime)
                .from(payLog);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default PayLog selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, outTradeNo, tradeType, tradeNo, payChannel, totalAmount, userId, payStatus, createTime, updateTime)
                .from(payLog)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, payLog)
                .set(id).equalTo(record::getId)
                .set(outTradeNo).equalTo(record::getOutTradeNo)
                .set(tradeType).equalTo(record::getTradeType)
                .set(tradeNo).equalTo(record::getTradeNo)
                .set(payChannel).equalTo(record::getPayChannel)
                .set(totalAmount).equalTo(record::getTotalAmount)
                .set(userId).equalTo(record::getUserId)
                .set(payStatus).equalTo(record::getPayStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, payLog)
                .set(id).equalToWhenPresent(record::getId)
                .set(outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(tradeType).equalToWhenPresent(record::getTradeType)
                .set(tradeNo).equalToWhenPresent(record::getTradeNo)
                .set(payChannel).equalToWhenPresent(record::getPayChannel)
                .set(totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(payStatus).equalToWhenPresent(record::getPayStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, payLog)
                .set(outTradeNo).equalTo(record::getOutTradeNo)
                .set(tradeType).equalTo(record::getTradeType)
                .set(tradeNo).equalTo(record::getTradeNo)
                .set(payChannel).equalTo(record::getPayChannel)
                .set(totalAmount).equalTo(record::getTotalAmount)
                .set(userId).equalTo(record::getUserId)
                .set(payStatus).equalTo(record::getPayStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(PayLog record) {
        return UpdateDSL.updateWithMapper(this::update, payLog)
                .set(outTradeNo).equalToWhenPresent(record::getOutTradeNo)
                .set(tradeType).equalToWhenPresent(record::getTradeType)
                .set(tradeNo).equalToWhenPresent(record::getTradeNo)
                .set(payChannel).equalToWhenPresent(record::getPayChannel)
                .set(totalAmount).equalToWhenPresent(record::getTotalAmount)
                .set(userId).equalToWhenPresent(record::getUserId)
                .set(payStatus).equalToWhenPresent(record::getPayStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}