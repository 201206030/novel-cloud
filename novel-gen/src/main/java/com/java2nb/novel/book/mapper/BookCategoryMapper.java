package com.java2nb.novel.book.mapper;

import static com.java2nb.novel.book.mapper.BookCategoryDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.book.entity.BookCategory;
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
public interface BookCategoryMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookCategory> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookCategoryResult")
    BookCategory selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookCategoryResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="work_direction", property="workDirection", jdbcType=JdbcType.TINYINT),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="sort", property="sort", jdbcType=JdbcType.TINYINT),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_user_id", property="updateUserId", jdbcType=JdbcType.BIGINT),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BookCategory> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Integer id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookCategory)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookCategory record) {
        return insert(SqlBuilder.insert(record)
                .into(bookCategory)
                .map(id).toProperty("id")
                .map(workDirection).toProperty("workDirection")
                .map(name).toProperty("name")
                .map(sort).toProperty("sort")
                .map(createUserId).toProperty("createUserId")
                .map(createTime).toProperty("createTime")
                .map(updateUserId).toProperty("updateUserId")
                .map(updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookCategory record) {
        return insert(SqlBuilder.insert(record)
                .into(bookCategory)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(workDirection).toPropertyWhenPresent("workDirection", record::getWorkDirection)
                .map(name).toPropertyWhenPresent("name", record::getName)
                .map(sort).toPropertyWhenPresent("sort", record::getSort)
                .map(createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(updateUserId).toPropertyWhenPresent("updateUserId", record::getUpdateUserId)
                .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCategory>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, workDirection, name, sort, createUserId, createTime, updateUserId, updateTime)
                .from(bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCategory>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, workDirection, name, sort, createUserId, createTime, updateUserId, updateTime)
                .from(bookCategory);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookCategory selectByPrimaryKey(Integer id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, workDirection, name, sort, createUserId, createTime, updateUserId, updateTime)
                .from(bookCategory)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, bookCategory)
                .set(id).equalTo(record::getId)
                .set(workDirection).equalTo(record::getWorkDirection)
                .set(name).equalTo(record::getName)
                .set(sort).equalTo(record::getSort)
                .set(createUserId).equalTo(record::getCreateUserId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateUserId).equalTo(record::getUpdateUserId)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, bookCategory)
                .set(id).equalToWhenPresent(record::getId)
                .set(workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(name).equalToWhenPresent(record::getName)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, bookCategory)
                .set(workDirection).equalTo(record::getWorkDirection)
                .set(name).equalTo(record::getName)
                .set(sort).equalTo(record::getSort)
                .set(createUserId).equalTo(record::getCreateUserId)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateUserId).equalTo(record::getUpdateUserId)
                .set(updateTime).equalTo(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookCategory record) {
        return UpdateDSL.updateWithMapper(this::update, bookCategory)
                .set(workDirection).equalToWhenPresent(record::getWorkDirection)
                .set(name).equalToWhenPresent(record::getName)
                .set(sort).equalToWhenPresent(record::getSort)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateUserId).equalToWhenPresent(record::getUpdateUserId)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}