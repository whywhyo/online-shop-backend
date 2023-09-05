package com.ojq.exception;
import com.ojq.result.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;


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
        return Result.fail(null);
    }


}
