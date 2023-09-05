package com.ojq.exception;
import com.ojq.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Objects;


//AOP 面向切面
@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(AccessDeniedException.class) //异常处理器
    @ResponseBody
    public Result authError(AccessDeniedException e) {
        log.error(e.getMessage());
        return Result.fail("权限不足，请联系管理员");
    }

    @ExceptionHandler(MethodArgumentNotValidException.class) //异常处理器
    @ResponseBody
    public Result argumentError(MethodArgumentNotValidException e) {
        log.error(e.getMessage());
        //这个方法是得到校验参数的不通过原因的信息
        return Result.fail(Objects.requireNonNull(e.getBindingResult().getFieldError()).getDefaultMessage());
    }

    //自定义异常处理
    @ExceptionHandler(MyException.class)
    @ResponseBody
    public Result error(MyException exception) {
        return Result.build(null,exception.getCode(),exception.getMessage());
    }

    @ExceptionHandler(Exception.class) //异常处理器
    @ResponseBody
    public Result error(Exception e) {
        log.error(e.getMessage());
        e.printStackTrace();
        return Result.fail(e.getMessage());
    }


}
