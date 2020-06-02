package com.java2nb.novel.book.controller;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.entity.BookCategory;
import com.java2nb.novel.book.entity.BookContent;
import com.java2nb.novel.book.entity.BookIndex;
import com.java2nb.novel.book.service.BookService;
import com.java2nb.novel.book.vo.BookCommentVO;
import com.java2nb.novel.common.bean.PageBean;
import com.java2nb.novel.common.bean.ResultBean;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 小说微服务Controller
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@RestController
@RequestMapping("book")
@RequiredArgsConstructor
@Slf4j
@Api(tags = "小说相关接口")
public class BookController {

    private final BookService bookService;

    private final RabbitTemplate rabbitTemplate;

    /**
     * 小说分类列表查询接口
     */
    @ApiOperation("小说分类列表查询接口")
    @GetMapping("listBookCategory")
    public ResultBean<List<BookCategory>> listBookCategory() {
        return ResultBean.ok(bookService.listBookCategory());
    }

    /**
     * 小说详情信息查询接口
     */
    @ApiOperation("小说详情信息查询接口")
    @GetMapping("{id}")
    public ResultBean<Book> queryBookDetail(@ApiParam("小说ID") @PathVariable("id") Long id) {
        return ResultBean.ok(bookService.queryBookDetail(id));
    }

    /**
     * 小说排行信息查询接口
     */
    @ApiOperation("小说排行信息查询接口")
    @GetMapping("listRank")
    public ResultBean<List<Book>> listRank(@ApiParam(value = "排行类型，0:点击排行，1：更新排行，2：新书排行，3评论排行", defaultValue = "0") @RequestParam(value = "type", defaultValue = "0") Byte type) {
        return ResultBean.ok(bookService.listRank(type, 30));
    }

    /**
     * 点击量新增接口
     */
    @ApiOperation("点击量新增接口")
    @PostMapping("addVisitCount")
    public ResultBean addVisitCount(@ApiParam("小说ID") @RequestParam("bookId") Long bookId) {
        rabbitTemplate.convertAndSend("ADD-BOOK-VISIT-EXCHANGE", null, bookId);
        return ResultBean.ok();
    }

    /**
     * 章节相关信息查询接口
     * */
    @ApiOperation("章节相关信息查询接口")
    @GetMapping("queryBookIndexAbout")
    public ResultBean<Map<String,Object>> queryBookIndexAbout(@ApiParam("小说ID") @RequestParam("bookId") Long bookId,@ApiParam("最新章节目录ID") @RequestParam("lastBookIndexId")  Long lastBookIndexId) {
        Map<String,Object> data = new HashMap<>(2);
        //查询章节总数
        data.put("bookIndexCount",bookService.queryIndexCount(bookId));
        //查询最新章节内容
        String lastBookContent = bookService.queryBookContent(lastBookIndexId).getContent();
        if(lastBookContent.length()>42){
            lastBookContent=lastBookContent.substring(0,42);
        }
        data.put("lastBookContent",lastBookContent);
        return ResultBean.ok(data);
    }

    /**
     * 同类推荐书籍查询接口
     * */
    @ApiOperation("同类推荐书籍查询接口")
    @GetMapping("listRecBookByCatId")
    public ResultBean<List<Book>> listRecBookByCatId(@ApiParam("小说分类ID") @RequestParam("catId") Integer catId) {
        return ResultBean.ok(bookService.listRecBookByCatId(catId));
    }

    /**
     *书籍评论列表分页查询接口
     * */
    @ApiOperation("书籍评论列表分页查询接口")
    @GetMapping("listCommentByPage")
    public ResultBean<List<BookCommentVO>> listCommentByPage(@ApiParam("小说ID") @RequestParam("bookId") Long bookId, @ApiParam("当前页码") @RequestParam(value = "curr", defaultValue = "1") int page, @ApiParam("分页大小") @RequestParam(value = "limit", defaultValue = "5") int pageSize) {
        return ResultBean.ok(new PageBean<>(bookService.listBookCommentByPage(bookId,page,pageSize)));
    }

    /**
     * 小说目录列表查询接口
     * */
    @ApiOperation("小说目录列表查询接口")
    @GetMapping("listNewIndex")
    public ResultBean<List<BookIndex>> listNewIndex(@ApiParam("小说ID") @RequestParam("bookId") Long bookId,@ApiParam(value = "排序字符串，为空则按目录号排序") @RequestParam("orderBy") String orderBy,@ApiParam(value = "查询数量，为空则全部查询") @RequestParam("limit") Integer limit){
        return ResultBean.ok(bookService.listNewIndex(bookId,orderBy,limit));
    }

    /**
     * 首章目录ID查询接口
     * */
    @ApiOperation("首章目录ID查询接口")
    @GetMapping("queryFirstBookIndexId")
    public ResultBean<Long> queryFirstBookIndexId(@ApiParam("小说ID") @RequestParam("bookId") Long bookId){
        return ResultBean.ok(bookService.queryFirstBookIndexId(bookId));
    }

    /**
     * 目录查询接口
     * */
    @ApiOperation("目录查询接口")
    @GetMapping("queryBookIndex")
    public ResultBean<BookIndex> queryBookIndex(@ApiParam("目录ID") @RequestParam("bookIndexId") Long bookIndexId){
        return ResultBean.ok(bookService.queryBookIndex(bookIndexId));
    }

    /**
     * 上一章节和下一章节目录ID查询接口
     * */
    @ApiOperation("上一章节和下一章节目录ID查询接口")
    @GetMapping("queryPreAndNextBookIndexId")
    public ResultBean<Map<String,Long>> queryPreAndNextBookIndexId(@ApiParam("小说ID") @RequestParam("bookId") Long bookId,@ApiParam("目录号") @RequestParam("indexNum") Integer indexNum){
        return ResultBean.ok(bookService.queryPreAndNextBookIndexId(bookId,indexNum));
    }

    /**
     * 内容查询接口
     * */
    @ApiOperation("内容查询接口")
    @GetMapping("queryBookContent")
    public ResultBean<BookContent> queryBookContent(@ApiParam("目录ID") @RequestParam("bookIndexId") Long bookIndexId){
        return ResultBean.ok(bookService.queryBookContent(bookIndexId));
    }

















}
