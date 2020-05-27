package com.java2nb.novel.book.mapper;

import static com.java2nb.novel.book.mapper.BookIndexDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.book.entity.BookIndex;
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
public interface BookIndexMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookIndex> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookIndexResult")
    BookIndex selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookIndexResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="index_num", property="indexNum", jdbcType=JdbcType.INTEGER),
        @Result(column="index_name", property="indexName", jdbcType=JdbcType.VARCHAR),
        @Result(column="word_count", property="wordCount", jdbcType=JdbcType.INTEGER),
        @Result(column="is_vip", property="isVip", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<BookIndex> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookIndex)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookIndex record) {
        return insert(SqlBuilder.insert(record)
                .into(bookIndex)
                .map(id).toProperty("id")
                .map(bookId).toProperty("bookId")
                .map(indexNum).toProperty("indexNum")
                .map(indexName).toProperty("indexName")
                .map(wordCount).toProperty("wordCount")
                .map(isVip).toProperty("isVip")
                .map(createTime).toProperty("createTime")
                .map(updateTime).toProperty("updateTime")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookIndex record) {
        return insert(SqlBuilder.insert(record)
                .into(bookIndex)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(bookId).toPropertyWhenPresent("bookId", record::getBookId)
                .map(indexNum).toPropertyWhenPresent("indexNum", record::getIndexNum)
                .map(indexName).toPropertyWhenPresent("indexName", record::getIndexName)
                .map(wordCount).toPropertyWhenPresent("wordCount", record::getWordCount)
                .map(isVip).toPropertyWhenPresent("isVip", record::getIsVip)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(updateTime).toPropertyWhenPresent("updateTime", record::getUpdateTime)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookIndex>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, bookId, indexNum, indexName, wordCount, isVip, createTime, updateTime)
                .from(bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookIndex>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, bookId, indexNum, indexName, wordCount, isVip, createTime, updateTime)
                .from(bookIndex);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookIndex selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, bookId, indexNum, indexName, wordCount, isVip, createTime, updateTime)
                .from(bookIndex)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, bookIndex)
                .set(id).equalTo(record::getId)
                .set(bookId).equalTo(record::getBookId)
                .set(indexNum).equalTo(record::getIndexNum)
                .set(indexName).equalTo(record::getIndexName)
                .set(wordCount).equalTo(record::getWordCount)
                .set(isVip).equalTo(record::getIsVip)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, bookIndex)
                .set(id).equalToWhenPresent(record::getId)
                .set(bookId).equalToWhenPresent(record::getBookId)
                .set(indexNum).equalToWhenPresent(record::getIndexNum)
                .set(indexName).equalToWhenPresent(record::getIndexName)
                .set(wordCount).equalToWhenPresent(record::getWordCount)
                .set(isVip).equalToWhenPresent(record::getIsVip)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, bookIndex)
                .set(bookId).equalTo(record::getBookId)
                .set(indexNum).equalTo(record::getIndexNum)
                .set(indexName).equalTo(record::getIndexName)
                .set(wordCount).equalTo(record::getWordCount)
                .set(isVip).equalTo(record::getIsVip)
                .set(createTime).equalTo(record::getCreateTime)
                .set(updateTime).equalTo(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookIndex record) {
        return UpdateDSL.updateWithMapper(this::update, bookIndex)
                .set(bookId).equalToWhenPresent(record::getBookId)
                .set(indexNum).equalToWhenPresent(record::getIndexNum)
                .set(indexName).equalToWhenPresent(record::getIndexName)
                .set(wordCount).equalToWhenPresent(record::getWordCount)
                .set(isVip).equalToWhenPresent(record::getIsVip)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(updateTime).equalToWhenPresent(record::getUpdateTime)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}