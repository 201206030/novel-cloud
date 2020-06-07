package com.java2nb.novel.book.api;

import com.java2nb.novel.book.entity.Book;
import com.java2nb.novel.book.entity.BookComment;
import com.java2nb.novel.book.vo.BookCommentVO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

/**
 * 小说微服务API接口定义（内部）
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/28
 */
public interface BookApi {

    /**
     * 根据最小更新时间分页查询书籍列表
     * @param minDate 最小时间，包括该时间
     * @param limit 查询数量
     * @return 书籍列表
     * */
    @GetMapping("api/book/queryBookByMinUpdateTime")
    List<Book> queryBookByMinUpdateTime(@RequestParam("minDate") Date minDate,@RequestParam("limit") int limit);

    /**
     * 根据小说ID集合查询书籍列表
     * @param ids 小说ID集合
     * @return 书籍列表
     * */
    @GetMapping("api/book/queryBookByIds")
    List<Book> queryBookByIds(@RequestBody List<Long> ids);

    /**
     * 小说排行数据查询列表
     * @param type 排行类型，1：更新排行，2：新书排行，3评论排行
     * @param limit 查询数量
     * @return 书籍列表
     * */
    @GetMapping("api/book/listRank")
    List<Book> listRank(@RequestParam("type") Byte type, @RequestParam("limit") Integer limit);

    /**
     * 根据小说ID查询书籍
     * @param id 小说ID
     * @return 书籍对象
     * */
    @GetMapping("api/book/queryBookById")
    Book queryBookById(@RequestParam("id") Long id);

    /**
     * 新增评论
     * @param userId 用户ID
     * @param comment 评论数据
     * @return true:评论成功，false:评论失败
     * */
    @PostMapping("api/book/addBookComment")
    boolean addBookComment(@RequestParam("userId") Long userId,@RequestBody BookComment comment);

    /**
     * 分页查询用户评论
     * @param userId 用户ID
     * @param page 查询页码
     * @param pageSize 分页大小
     * @return 评论数据
     * */
    @GetMapping("api/book/listUserCommentByPage")
    List<BookComment> listUserCommentByPage(@RequestParam("userId") Long userId,@RequestParam("page")  int page, @RequestParam("pageSize") int pageSize);

    /**
     * 查询网络图片的小说
     *
     * @param localPicPrefix
     * @param limit 查询条数
     * @return 返回小说集合
     * */
    @GetMapping("api/book/queryNetworkPicBooks")
    List<Book> queryNetworkPicBooks(@RequestParam("localPicPrefix") String localPicPrefix,@RequestParam("limit") int limit);


    /**
     * 更新图片路径
     * @param picUrl 图片路径
     * @param bookId 小说ID
     * @return true:更新成功，false:更新失败
     */
    @PostMapping("api/book/updateBookPic")
    boolean updateBookPic(@RequestParam("picUrl") String picUrl,@RequestParam("bookId") Long bookId);
}
