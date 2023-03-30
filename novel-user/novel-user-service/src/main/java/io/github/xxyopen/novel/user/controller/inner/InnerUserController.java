package io.github.xxyopen.novel.user.controller.inner;

import io.github.xxyopen.novel.common.constant.ApiRouterConsts;
import io.github.xxyopen.novel.common.resp.RestResp;
import io.github.xxyopen.novel.user.dto.resp.UserInfoRespDto;
import io.github.xxyopen.novel.user.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 用户微服务内部调用接口
 *
 * @author xiongxiaoyang
 * @date 2023/3/29
 */
@Tag(name = "InnerBookController", description = "内部调用-用户模块")
@RestController
@RequestMapping(ApiRouterConsts.API_INNER_USER_URL_PREFIX)
@RequiredArgsConstructor
public class InnerUserController {

    private final UserService userService;

    /**
     * 批量查询用户信息
     */
    @Operation(summary = "批量查询用户信息")
    @PostMapping("listUserInfoByIds")
    RestResp<List<UserInfoRespDto>> listUserInfoByIds(@RequestBody List<Long> userIds) {
        return userService.listUserInfoByIds(userIds);
    }

}
