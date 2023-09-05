package com.ojq.controller;

import com.ojq.result.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-04 20:01
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/test")
public class TestController {

    @GetMapping("/first")
    public Result first(){
        return Result.success("测试成功");
    }
}
