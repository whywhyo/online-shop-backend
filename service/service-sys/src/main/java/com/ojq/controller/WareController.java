package com.ojq.controller;


import com.ojq.result.Result;
import com.ojq.service.WareService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 仓库表 前端控制器
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
@RestController
@RequestMapping("/admin/ware")
public class WareController {

    @Resource
    private WareService wareService;

    @ApiOperation(value = "获取全部仓库")
    @GetMapping("findAllList")
    public Result findAllList() {
        return Result.success(wareService.list());
    }

}
