package com.java2nb.novel.user.mapper;

import java.sql.JDBCType;
import java.util.Date;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class UserPayRecordDynamicSqlSupport {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final UserPayRecord userPayRecord = new UserPayRecord();

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> id = userPayRecord.id;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> userId = userPayRecord.userId;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Byte> payChannel = userPayRecord.payChannel;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Long> outTradeNo = userPayRecord.outTradeNo;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> totalAmount = userPayRecord.totalAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Integer> wuAmount = userPayRecord.wuAmount;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final SqlColumn<Date> payTime = userPayRecord.payTime;

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    public static final class UserPayRecord extends SqlTable {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> userId = column("user_id", JDBCType.BIGINT);

        public final SqlColumn<Byte> payChannel = column("pay_channel", JDBCType.TINYINT);

        public final SqlColumn<Long> outTradeNo = column("out_trade_no", JDBCType.BIGINT);

        public final SqlColumn<Integer> totalAmount = column("total_amount", JDBCType.INTEGER);

        public final SqlColumn<Integer> wuAmount = column("wu_amount", JDBCType.INTEGER);

        public final SqlColumn<Date> payTime = column("pay_time", JDBCType.TIMESTAMP);

        public UserPayRecord() {
            super("user_pay_record");
        }
    }
}