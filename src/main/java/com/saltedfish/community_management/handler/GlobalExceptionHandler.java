package com.saltedfish.community_management.handler;

import com.saltedfish.community_management.common.Result;
import com.saltedfish.community_management.common.ResultCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 未知异常处理
     * @param exception 异常
     * @return 异常处理响应信息
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Object unkownExceptionHandler(Exception exception){
        log.info(exception.getMessage());
        return new Result(HttpStatus.INTERNAL_SERVER_ERROR.value(),"系统繁忙",null);
    }
}
