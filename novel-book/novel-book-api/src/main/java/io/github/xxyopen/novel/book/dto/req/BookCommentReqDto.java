package io.github.xxyopen.novel.book.dto.req;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

/**
 * 小说评论 请求DTO
 * @author xiongxiaoyang
 * @date 2022/5/17
 */
@Data
public class BookCommentReqDto {

    private Long commentId;

    private Long userId;

    @Schema(description = "小说ID")
    private Long bookId;

    @Schema(description = "评论内容")
    private String commentContent;

}
