package io.github.xxyopen.novel.book.feign;

import io.github.xxyopen.novel.book.dto.req.*;
import io.github.xxyopen.novel.book.dto.resp.BookChapterRespDto;
import io.github.xxyopen.novel.book.dto.resp.BookEsRespDto;
import io.github.xxyopen.novel.book.dto.resp.BookInfoRespDto;
import io.github.xxyopen.novel.common.constant.ApiRouterConsts;
import io.github.xxyopen.novel.common.constant.ErrorCodeEnum;
import io.github.xxyopen.novel.common.resp.PageRespDto;
import io.github.xxyopen.novel.common.resp.RestResp;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

/**
 * 小说微服务调用客户端
 *
 * @author xiongxiaoyang
 * @date 2023/3/29
 */
@Component
@FeignClient(value = "novel-book-service", fallback = BookFeign.BookFeignFallback.class)
public interface BookFeign {

    /**
     * 查询下一批保存到 ES 中的小说列表
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/listNextEsBooks")
    RestResp<List<BookEsRespDto>> listNextEsBooks(Long maxBookId);

    /**
     * 批量查询小说信息
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/listBookInfoByIds")
    RestResp<List<BookInfoRespDto>> listBookInfoByIds(List<Long> bookIds);

    /**
     * 发表评论
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/publishComment")
    RestResp<Void> publishComment(BookCommentReqDto dto);

    /**
     * 修改评论
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/updateComment")
    RestResp<Void> updateComment(BookCommentReqDto dto);

    /**
     * 删除评论接口
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/deleteComment")
    RestResp<Void> deleteComment(@RequestBody BookCommentReqDto dto);

    /**
     * 小说发布接口
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/publishBook")
    RestResp<Void> publishBook(BookAddReqDto dto);

    /**
     * 小说发布列表查询接口
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/listPublishBooks")
    RestResp<PageRespDto<BookInfoRespDto>> listPublishBooks(BookPageReqDto dto);

    /**
     * 小说章节发布接口
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/publishBookChapter")
    RestResp<Void> publishBookChapter(ChapterAddReqDto dto);

    /**
     * 小说章节发布列表查询接口
     */
    @PostMapping(ApiRouterConsts.API_INNER_BOOK_URL_PREFIX + "/listPublishBookChapters")
    RestResp<PageRespDto<BookChapterRespDto>> listPublishBookChapters(ChapterPageReqDto dto);

    @Component
    class BookFeignFallback implements BookFeign {

        @Override
        public RestResp<List<BookEsRespDto>> listNextEsBooks(Long maxBookId) {
            return RestResp.ok(new ArrayList<>(0));
        }

        @Override
        public RestResp<List<BookInfoRespDto>> listBookInfoByIds(List<Long> bookIds) {
            return RestResp.ok(new ArrayList<>(0));
        }

        @Override
        public RestResp<Void> publishComment(BookCommentReqDto dto) {
            return RestResp.fail(ErrorCodeEnum.THIRD_SERVICE_ERROR);
        }

        @Override
        public RestResp<Void> updateComment(BookCommentReqDto dto) {
            return RestResp.fail(ErrorCodeEnum.THIRD_SERVICE_ERROR);
        }

        @Override
        public RestResp<Void> deleteComment(BookCommentReqDto dto) {
            return RestResp.fail(ErrorCodeEnum.THIRD_SERVICE_ERROR);
        }

        @Override
        public RestResp<Void> publishBook(BookAddReqDto dto) {
            return RestResp.fail(ErrorCodeEnum.THIRD_SERVICE_ERROR);
        }

        @Override
        public RestResp<PageRespDto<BookInfoRespDto>> listPublishBooks(BookPageReqDto dto) {
            return RestResp.ok(PageRespDto.of(dto.getPageNum(), dto.getPageSize(), 0, new ArrayList<>(0)));
        }

        @Override
        public RestResp<Void> publishBookChapter(ChapterAddReqDto dto) {
            return RestResp.fail(ErrorCodeEnum.THIRD_SERVICE_ERROR);
        }

        @Override
        public RestResp<PageRespDto<BookChapterRespDto>> listPublishBookChapters(ChapterPageReqDto dto) {
            return RestResp.ok(PageRespDto.of(dto.getPageNum(), dto.getPageSize(), 0, new ArrayList<>(0)));
        }
    }

}
