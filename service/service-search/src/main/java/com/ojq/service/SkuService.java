package com.ojq.service;

import com.ojq.domain.dto.es.SkuEsQueryDto;
import com.ojq.search.SkuEs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 17:28
 * @Version 1.0.0
 **/
public interface SkuService {
    void upperSku(Long skuId);

    //下架
    void lowerSku(Long skuId);

    //获取爆款商品
    List<SkuEs> findHotSkuList();

    //查询分类商品
    Page<SkuEs> search(Pageable pageable, SkuEsQueryDto skuEsQueryDto);

    //更新商品热度
    void incrHotScore(Long skuId);
}
