package com.java2nb.novel.common.exception;

import com.java2nb.novel.common.bean.ResultBean;
import com.java2nb.novel.common.enums.ResponseStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 通用的异常处理器
 * @author xiongxiaoyang
 * @version 1.0
 * @since 2020/5/23
 * */
@Slf4j
@RestControllerAdvice
public class CommonExceptionHandler {

    /**
     * 处理后台数据校验异常
     * */
    @ExceptionHandler(BindException.class)
    public ResultBean handlerBindException(BindException e){
        log.error(e.getMessage(),e);
        return ResultBean.fail(ResponseStatus.PARAM_ERROR);
    }

    /**
     * 处理业务异常
     * */
    @ExceptionHandler(BusinessException.class)
    public ResultBean handlerBusinessException(BusinessException e){
        log.error(e.getMessage(),e);
        return ResultBean.fail(e.getResStatus());
    }


    /**
     * 处理系统异常
     * */
    @ExceptionHandler(Exception.class)
    public ResultBean handlerException(Exception e){
        log.error(e.getMessage(),e);
        return ResultBean.error();
    }
}
