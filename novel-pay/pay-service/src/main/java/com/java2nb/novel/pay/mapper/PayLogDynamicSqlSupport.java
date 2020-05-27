package com.java2nb.novel.pay.mapper;

import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

import javax.annotation.Generated;
import java.sql.JDBCType;
import java.util.Date;

public final class PayLogDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final PayLog payLog = new PayLog();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = payLog.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> outTradeNo = payLog.outTradeNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> tradeType = payLog.tradeType;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> tradeNo = payLog.tradeNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> payChannel = payLog.payChannel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> totalAmount = payLog.totalAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> userId = payLog.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<String> payStatus = payLog.payStatus;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> createTime = payLog.createTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> updateTime = payLog.updateTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class PayLog extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> outTradeNo = column("out_trade_no", JDBCType.BIGINT);

        public final SqlColumn<Byte> tradeType = column("trade_type", JDBCType.TINYINT);

        public final SqlColumn<String> tradeNo = column("trade_no", JDBCType.VARCHAR);

        public final SqlColumn<Byte> payChannel = column("pay_channel", JDBCType.TINYINT);

        public final SqlColumn<Integer> totalAmount = column("total_amount", JDBCType.INTEGER);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<String> payStatus = column("pay_status", JDBCType.VARCHAR);

        public final SqlColumn<Date> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Date> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public PayLog() {
            super("pay_log");
        }
    }
}