package com.java2nb.novel.book.controller.api;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.entity.BookComment;
import com.java2nb.novel.book.service.BookService;
import com.java2nb.novel.book.vo.BookCommentVO;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

/**
 * 小说微服务API接口（内部调用）
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/27
 */
@RestController
@RequestMapping(("api/book"))
@ApiIgnore
@RequiredArgsConstructor
public class BookApi {

    private final BookService bookService;

    /**
     * 根据最小更新时间分页查询书籍列表
     * @param minDate 最小时间，包括该时间
     * @param limit 查询数量
     * @return 书籍列表
     * */
    @GetMapping("queryBookByMinUpdateTime")
    List<Book> queryBookByMinUpdateTime(Date minDate, int limit){

        return bookService.queryBookByMinUpdateTime(minDate,limit);
    }

    /**
     * 根据小说ID集合查询书籍列表
     * @param ids 小说ID集合
     * @return 书籍列表
     * */
    @GetMapping("queryBookByIds")
    List<Book> queryBookByIds(@RequestBody List<Long> ids){

        return bookService.queryBookByIds(ids);
    }

    /**
     * 小说排行数据查询列表
     * @param type 排行类型，1：更新排行，2：新书排行，3评论排行
     * @param limit 查询数量
     * @return 书籍列表
     * */
    @GetMapping("listRank")
    List<Book> listRank(Byte type, Integer limit){
        return bookService.listRank(type,limit);
    }


    /**
     * 根据小说ID查询书籍
     * @param id 小说ID
     * @return 书籍对象
     * */
    @GetMapping("queryBookById")
    Book queryBookById(@RequestParam("id") Long id){
        return bookService.queryBookDetail(id);
    }

    /**
     * 新增评论
     * @param userId 用户ID
     * @param comment 评论数据
     * */
    @PostMapping("addBookComment")
    boolean addBookComment(@RequestParam("userId") Long userId, @RequestBody BookComment comment){
        bookService.addBookComment(userId,comment);
        return true;
    }

    /**
     * 分页查询用户评论
     * @param userId 用户ID
     * @param page 查询页码
     * @param pageSize 分页大小
     * @return 评论数据
     * */
    @GetMapping("listUserCommentByPage")
    List<BookComment> listUserCommentByPage(@RequestParam("userId") Long userId,@RequestParam("page")  int page, @RequestParam("pageSize") int pageSize){
        return bookService.listUserCommentByPage(userId,page,pageSize);
    }

    /**
     * 查询网络图片的小说
     *
     * @param localPicPrefix
     * @param limit 查询条数
     * @return 返回小说集合
     * */
    @GetMapping("queryNetworkPicBooks")
    List<Book> queryNetworkPicBooks(@RequestParam("localPicPrefix") String localPicPrefix,@RequestParam("limit") int limit){
        return bookService.queryNetworkPicBooks(localPicPrefix,limit);
    }

    /**
     * 更新图片路径
     * @param picUrl 图片路径
     * @param bookId 小说ID
     */
    @PostMapping("updateBookPic")
    boolean updateBookPic(@RequestParam("picUrl") String picUrl,@RequestParam("bookId") Long bookId){
        bookService.updateBookPic(picUrl,bookId);
        return true;
    }

}
