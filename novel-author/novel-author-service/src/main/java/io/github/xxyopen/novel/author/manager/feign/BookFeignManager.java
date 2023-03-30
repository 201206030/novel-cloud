package io.github.xxyopen.novel.author.manager.feign;

import io.github.xxyopen.novel.author.dto.AuthorInfoDto;
import io.github.xxyopen.novel.author.manager.cache.AuthorInfoCacheManager;
import io.github.xxyopen.novel.book.dto.req.BookAddReqDto;
import io.github.xxyopen.novel.book.dto.req.BookPageReqDto;
import io.github.xxyopen.novel.book.dto.req.ChapterAddReqDto;
import io.github.xxyopen.novel.book.dto.req.ChapterPageReqDto;
import io.github.xxyopen.novel.book.dto.resp.BookChapterRespDto;
import io.github.xxyopen.novel.book.dto.resp.BookEsRespDto;
import io.github.xxyopen.novel.book.dto.resp.BookInfoRespDto;
import io.github.xxyopen.novel.book.feign.BookFeign;
import io.github.xxyopen.novel.common.auth.UserHolder;
import io.github.xxyopen.novel.common.constant.ErrorCodeEnum;
import io.github.xxyopen.novel.common.req.PageReqDto;
import io.github.xxyopen.novel.common.resp.PageRespDto;
import io.github.xxyopen.novel.common.resp.RestResp;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 小说微服务调用 Feign 客户端管理
 *
 * @author xiongxiaoyang
 * @date 2023/3/29
 */
@Component
@AllArgsConstructor
public class BookFeignManager {

    private final BookFeign bookFeign;

    private final AuthorInfoCacheManager authorInfoCacheManager;

    public RestResp<Void> publishBook(BookAddReqDto dto) {
        AuthorInfoDto author = authorInfoCacheManager.getAuthor(UserHolder.getUserId());
        dto.setAuthorId(author.getId());
        dto.setPenName(author.getPenName());
        return bookFeign.publishBook(dto);
    }

    public RestResp<PageRespDto<BookInfoRespDto>> listPublishBooks(BookPageReqDto dto) {
        authorInfoCacheManager.getAuthor(UserHolder.getUserId());
        return bookFeign.listPublishBooks(dto);
    }

    public RestResp<Void> publishBookChapter(ChapterAddReqDto dto) {
        return bookFeign.publishBookChapter(dto);
    }

    public RestResp<PageRespDto<BookChapterRespDto>> listPublishBookChapters(ChapterPageReqDto dto) {
        return bookFeign.listPublishBookChapters(dto);
    }


}
