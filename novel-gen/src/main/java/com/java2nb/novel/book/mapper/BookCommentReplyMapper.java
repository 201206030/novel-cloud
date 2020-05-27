package com.java2nb.novel.book.mapper;

import static com.java2nb.novel.book.mapper.BookCommentReplyDynamicSqlSupport.*;
import static org.mybatis.dynamic.sql.SqlBuilder.*;

import com.java2nb.novel.book.entity.BookCommentReply;
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
public interface BookCommentReplyMapper {
    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    long count(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @DeleteProvider(type=SqlProviderAdapter.class, method="delete")
    int delete(DeleteStatementProvider deleteStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @InsertProvider(type=SqlProviderAdapter.class, method="insert")
    int insert(InsertStatementProvider<BookCommentReply> insertStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("BookCommentReplyResult")
    BookCommentReply selectOne(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="BookCommentReplyResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="comment_id", property="commentId", jdbcType=JdbcType.BIGINT),
        @Result(column="reply_content", property="replyContent", jdbcType=JdbcType.VARCHAR),
        @Result(column="audit_status", property="auditStatus", jdbcType=JdbcType.TINYINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="create_user_id", property="createUserId", jdbcType=JdbcType.BIGINT)
    })
    List<BookCommentReply> selectMany(SelectStatementProvider selectStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    @UpdateProvider(type=SqlProviderAdapter.class, method="update")
    int update(UpdateStatementProvider updateStatement);

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<Long>> countByExample() {
        return SelectDSL.selectWithMapper(this::count, SqlBuilder.count())
                .from(bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default DeleteDSL<MyBatis3DeleteModelAdapter<Integer>> deleteByExample() {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int deleteByPrimaryKey(Long id_) {
        return DeleteDSL.deleteFromWithMapper(this::delete, bookCommentReply)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insert(BookCommentReply record) {
        return insert(SqlBuilder.insert(record)
                .into(bookCommentReply)
                .map(id).toProperty("id")
                .map(commentId).toProperty("commentId")
                .map(replyContent).toProperty("replyContent")
                .map(auditStatus).toProperty("auditStatus")
                .map(createTime).toProperty("createTime")
                .map(createUserId).toProperty("createUserId")
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int insertSelective(BookCommentReply record) {
        return insert(SqlBuilder.insert(record)
                .into(bookCommentReply)
                .map(id).toPropertyWhenPresent("id", record::getId)
                .map(commentId).toPropertyWhenPresent("commentId", record::getCommentId)
                .map(replyContent).toPropertyWhenPresent("replyContent", record::getReplyContent)
                .map(auditStatus).toPropertyWhenPresent("auditStatus", record::getAuditStatus)
                .map(createTime).toPropertyWhenPresent("createTime", record::getCreateTime)
                .map(createUserId).toPropertyWhenPresent("createUserId", record::getCreateUserId)
                .build()
                .render(RenderingStrategy.MYBATIS3));
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCommentReply>>> selectByExample() {
        return SelectDSL.selectWithMapper(this::selectMany, id, commentId, replyContent, auditStatus, createTime, createUserId)
                .from(bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default QueryExpressionDSL<MyBatis3SelectModelAdapter<List<BookCommentReply>>> selectDistinctByExample() {
        return SelectDSL.selectDistinctWithMapper(this::selectMany, id, commentId, replyContent, auditStatus, createTime, createUserId)
                .from(bookCommentReply);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default BookCommentReply selectByPrimaryKey(Long id_) {
        return SelectDSL.selectWithMapper(this::selectOne, id, commentId, replyContent, auditStatus, createTime, createUserId)
                .from(bookCommentReply)
                .where(id, isEqualTo(id_))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExample(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, bookCommentReply)
                .set(id).equalTo(record::getId)
                .set(commentId).equalTo(record::getCommentId)
                .set(replyContent).equalTo(record::getReplyContent)
                .set(auditStatus).equalTo(record::getAuditStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default UpdateDSL<MyBatis3UpdateModelAdapter<Integer>> updateByExampleSelective(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, bookCommentReply)
                .set(id).equalToWhenPresent(record::getId)
                .set(commentId).equalToWhenPresent(record::getCommentId)
                .set(replyContent).equalToWhenPresent(record::getReplyContent)
                .set(auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId);
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKey(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, bookCommentReply)
                .set(commentId).equalTo(record::getCommentId)
                .set(replyContent).equalTo(record::getReplyContent)
                .set(auditStatus).equalTo(record::getAuditStatus)
                .set(createTime).equalTo(record::getCreateTime)
                .set(createUserId).equalTo(record::getCreateUserId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }

    @Generated("org.mybatis.generator.api.MyBatisGenerator")
    default int updateByPrimaryKeySelective(BookCommentReply record) {
        return UpdateDSL.updateWithMapper(this::update, bookCommentReply)
                .set(commentId).equalToWhenPresent(record::getCommentId)
                .set(replyContent).equalToWhenPresent(record::getReplyContent)
                .set(auditStatus).equalToWhenPresent(record::getAuditStatus)
                .set(createTime).equalToWhenPresent(record::getCreateTime)
                .set(createUserId).equalToWhenPresent(record::getCreateUserId)
                .where(id, isEqualTo(record::getId))
                .build()
                .execute();
    }
}