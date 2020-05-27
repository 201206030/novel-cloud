package com.java2nb.novel.book.mapper;

import static com.java2nb.novel.book.mapper.BookCommentDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.book.entity.BookComment;
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
public interface BookCommentMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookComment> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookCommentResult")
    BookComment selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookCommentResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="book_id", property="bookId", jdbcType=JdbcType.BIGINT),
        @Result(column="comment_content", property="commentContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="reply_count", property="replyCount", jdbcType=JdbcType.INTEGER),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT)
    })
    List<BookComment> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookComment)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookComment record) {
        return insert(SqlBuilder.insert(record)
                .into(bookComment)
                .map(id).toProperty("id")
                .map(bookId).toProperty("bookId")
                .map(commentContent).toProperty("commentContent")
                .map(replyCount).toProperty("replyCount")
                .map(auditStatus).toProperty("auditStatus")
                .map(createTime).toProperty("createTime")
                .map(createUserId).toProperty("createUserId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookComment record) {
        return insert(SqlBuilder.insert(record)
                .into(bookComment)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(bookId).toPropertyWhenPresent("bookId", record::getBookId)
                .map(commentContent).toPropertyWhenPresent("commentContent", record::getCommentContent)
                .map(replyCount).toPropertyWhenPresent("replyCount", record::getReplyCount)
                .map(auditStatus).toPropertyWhenPresent("auditStatus", record::getAuditStatus)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookComment>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, bookId, commentContent, replyCount, auditStatus, createTime, createUserId)
                .from(bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookComment>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, bookId, commentContent, replyCount, auditStatus, createTime, createUserId)
                .from(bookComment);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookComment selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, bookId, commentContent, replyCount, auditStatus, createTime, createUserId)
                .from(bookComment)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, bookComment)
                .set(id).equalTo(record::getId)
                .set(bookId).equalTo(record::getBookId)
                .set(commentContent).equalTo(record::getCommentContent)
                .set(replyCount).equalTo(record::getReplyCount)
                .set(auditStatus).equalTo(record::getAuditStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, bookComment)
                .set(id).equalToWhenPresent(record::getId)
                .set(bookId).equalToWhenPresent(record::getBookId)
                .set(commentContent).equalToWhenPresent(record::getCommentContent)
                .set(replyCount).equalToWhenPresent(record::getReplyCount)
                .set(auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, bookComment)
                .set(bookId).equalTo(record::getBookId)
                .set(commentContent).equalTo(record::getCommentContent)
                .set(replyCount).equalTo(record::getReplyCount)
                .set(auditStatus).equalTo(record::getAuditStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookComment record) {
        return UpdateDSL.updateWithMapper(this::update, bookComment)
                .set(bookId).equalToWhenPresent(record::getBookId)
                .set(commentContent).equalToWhenPresent(record::getCommentContent)
                .set(replyCount).equalToWhenPresent(record::getReplyCount)
                .set(auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}