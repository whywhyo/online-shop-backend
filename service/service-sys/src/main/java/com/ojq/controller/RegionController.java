package com.ojq.controller;


import com.ojq.result.Result;
import com.ojq.service.RegionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 * 地区表 前端控制器
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
@RestController
@RequestMapping("/admin/region")
public class RegionController {

    @Resource
    private RegionService regionService;

    @ApiOperation(value = "根据地区名字关键字获取地区列表")
    @GetMapping("findRegionByKeyword/{keyword}")
    public Result findSkuInfoByKeyword(@PathVariable("keyword") String keyword) {
        return Result.success(regionService.findRegionByKeyword(keyword));
    }

}
