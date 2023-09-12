package com.ojq.controller;

import com.ojq.domain.dto.es.SkuEsQueryDto;
import com.ojq.result.Result;
import com.ojq.search.SkuEs;
import com.ojq.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 17:27
 * @Version 1.0.0
 **/
@RestController
@RequestMapping("/api/search/sku")
public class SkuApiController {

    @Autowired
    private SkuService skuService;

    //查询分类商品
    @GetMapping("{page}/{limit}")
    public Result listSku(@PathVariable Integer page,
                          @PathVariable Integer limit,
                          SkuEsQueryDto skuEsQueryDto) {
        //创建pageable对象，0代表第一页
        Pageable pageable = PageRequest.of(page-1,limit);
        Page<SkuEs> pageModel = skuService.search(pageable,skuEsQueryDto);
        return Result.success(pageModel);
    }

    //上架
    @GetMapping("inner/upperSku/{skuId}")
    public Result upperSku(@PathVariable Long skuId) {
        skuService.upperSku(skuId);
        return Result.success(null);
    }

    //下架
    @GetMapping("inner/lowerSku/{skuId}")
    public Result lowerSku(@PathVariable Long skuId) {
        skuService.lowerSku(skuId);
        return Result.success(null);
    }

    //获取爆款商品
    @GetMapping("inner/findHotSkuList")
    public List<SkuEs> findHotSkuList() {
        return skuService.findHotSkuList();
    }

    //更新商品热度
    @GetMapping("inner/incrHotScore/{skuId}")
    public Boolean incrHotScore(@PathVariable("skuId") Long skuId) {
        skuService.incrHotScore(skuId);
        return true;
    }
}
