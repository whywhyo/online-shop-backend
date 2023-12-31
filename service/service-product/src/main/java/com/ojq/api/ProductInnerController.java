package com.ojq.api;

import com.ojq.domain.dto.acl.SkuInfoDto;
import com.ojq.domain.po.product.Category;
import com.ojq.domain.po.product.SkuInfo;
import com.ojq.service.CategoryService;
import com.ojq.service.SkuInfoService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//远程调用的方法

@RestController
@RequestMapping("/api/product")
public class ProductInnerController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SkuInfoService skuInfoService;

    //根据分类id获取分类信息
    @GetMapping("inner/getCategory/{categoryId}")
    public Category getCategory(@PathVariable Long categoryId) {
        Category category = categoryService.getById(categoryId);
        return category;
    }

    //根据skuid获取sku信息
    @GetMapping("inner/getSkuInfo/{skuId}")
    public SkuInfo getSkuInfo(@PathVariable Long skuId) {
        return skuInfoService.getById(skuId);
    }

    //根据skuId列表得到sku信息列表
    @PostMapping("inner/findSkuInfoList")
    public List<SkuInfo> findSkuInfoList(@RequestBody List<Long> skuIdList) {
        return skuInfoService.findSkuInfoList(skuIdList);
    }

    //根据分类id获取分类列表
    @PostMapping("inner/findCategoryList")
    public List<Category> findCategoryList(@RequestBody List<Long> categoryIdList) {
        return categoryService.listByIds(categoryIdList);
    }

    //根据关键字匹配sku列表
    @GetMapping("inner/findSkuInfoByKeyword/{keyword}")
    public List<SkuInfo> findSkuInfoByKeyword(@PathVariable("keyword") String keyword) {
        return skuInfoService.findSkuInfoByKeyword(keyword);
    }

    //获取所有分类
    @GetMapping("inner/findAllCategoryList")
    public List<Category> findAllCategoryList() {
        List<Category> categoryList = categoryService.list();
        return categoryList;
    }

    //获取新人专享商品
    @GetMapping("inner/findNewPersonSkuInfoList")
    public List<SkuInfo> findNewPersonSkuInfoList() {
        List<SkuInfo> list = skuInfoService.findNewPersonSkuInfoList();
        return list;
    }

//    //根据skuId获取sku信息
//    @GetMapping("inner/getSkuInfoDto/{skuId}")
//    public SkuInfoDto getSkuInfoDto(@PathVariable Long skuId) {
//        return skuInfoService.getSkuInfoDto(skuId);
//    }

//    //验证和锁定库存
//    @ApiOperation(value = "锁定库存")
//    @PostMapping("inner/checkAndLock/{orderNo}")
//    public Boolean checkAndLock(@RequestBody List<SkuStockLockVo> skuStockLockVoList,
//                                @PathVariable String orderNo) {
//        return skuInfoService.checkAndLock(skuStockLockVoList,orderNo);
//    }
}
