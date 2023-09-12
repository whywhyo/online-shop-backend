package com.ojq.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ojq.domain.dto.acl.SkuInfoDto;
import com.ojq.domain.dto.acl.SkuInfoQueryDto;
import com.ojq.domain.po.product.SkuInfo;
import com.ojq.result.Result;
import com.ojq.service.SkuInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * sku信息 前端控制器
 * </p>
 *
 * @author atguigu
 * @since 2023-04-04
 */
@RestController
@RequestMapping("/admin/product/skuInfo")
//@CrossOrigin
public class SkuInfoController {

    @Autowired
    private SkuInfoService skuInfoService;

    //sku列表
//    url: `${api_name}/${page}/${limit}`,
//    method: 'get',
//    params: searchObj
    @ApiOperation("sku列表")
    @GetMapping("{page}/{limit}")
    public Result list(@PathVariable Long page,
                       @PathVariable Long limit,
                       SkuInfoQueryDto skuInfoQueryDto) {
        Page<SkuInfo> pageParam = new Page<>(page,limit);
        IPage<SkuInfo> pageModel =
                skuInfoService.selectPageSkuInfo(pageParam,skuInfoQueryDto);
        return Result.success(pageModel);
    }

    //添加商品sku信息
//    url: `${api_name}/save`,
//    method: 'post',
//    data: role
    @ApiOperation("添加商品sku信息")
    @PostMapping("save")
    public Result save(@RequestBody SkuInfoDto skuInfoDto) {
        skuInfoService.saveSkuInfo(skuInfoDto);
        return Result.success(null);
    }

//    url: `${api_name}/get/${id}`,
//    method: 'get'
    @ApiOperation("获取sku信息")
    @GetMapping("get/{id}")
    public Result get(@PathVariable Long id) {
        SkuInfoDto skuInfoDto = skuInfoService.getSkuInfo(id);
        return Result.success(skuInfoDto);
    }

//    url: `${api_name}/update`,
//    method: 'put',
//    data: role
    @ApiOperation("修改sku")
    @PutMapping("update")
    public Result update(@RequestBody SkuInfoDto skuInfoDto) {
        skuInfoService.updateSkuInfo(skuInfoDto);
        return Result.success(null);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("remove/{id}")
    public Result remove(@PathVariable Long id) {
        skuInfoService.removeById(id);
        return Result.success(null);
    }

    @ApiOperation(value = "根据id列表删除")
    @DeleteMapping("batchRemove")
    public Result batchRemove(@RequestBody List<Long> idList) {
        skuInfoService.removeByIds(idList);
        return Result.success(null);
    }

//    url: `${api_name}/check/${id}/${status}`,
//    method: 'get'
    @ApiOperation("商品审核")
    @GetMapping("check/{skuId}/{status}")
    public Result check(@PathVariable Long skuId,
                        @PathVariable Integer status) {
        skuInfoService.check(skuId,status);
        return Result.success(null);
    }

//    url: `${api_name}/publish/${id}/${status}`,
//    method: 'get'
    @ApiOperation("商品上下架")
    @GetMapping("publish/{skuId}/{status}")
    public Result publish(@PathVariable Long skuId,
                          @PathVariable Integer status) {
        skuInfoService.publish(skuId,status);
        return Result.success(null);
    }

    //新人专享
    @GetMapping("isNewPerson/{skuId}/{status}")
    public Result isNewPerson(@PathVariable("skuId") Long skuId,
                              @PathVariable("status") Integer status) {
        skuInfoService.isNewPerson(skuId, status);
        return Result.success(null);
    }
}

