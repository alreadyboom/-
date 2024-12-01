package com.example.exception;

import cn.hutool.log.Log;
import cn.hutool.log.LogFactory;
import com.example.common.Result;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
/*全局异常处理*/
@ControllerAdvice("com.example.controller") //需要捕获异常的文件包
public class GlobalExceptionHandler {

    private static final Log log = LogFactory.get();

    @ExceptionHandler(Exception.class)//捕获所有异常
    @ResponseBody // 返回json串
    public Result error(Exception e) {
        log.error("异常信息：", e);
        return Result.error();
    }

    @ExceptionHandler(CustomException.class)//捕获自定义异常
    @ResponseBody // 返回json串
    public Result error(CustomException e) {
//        log.error("异常信息：", e);
        return Result.error(e.getCode(), e.getMsg());
    }
}
