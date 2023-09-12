package com.ojq.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ojq.domain.dto.product.CategoryQueryDto;
import com.ojq.domain.po.product.Category;

/**
 * <p>
 * 商品三级分类 服务类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-04
 */
public interface CategoryService extends IService<Category> {

    //商品分类列表
    IPage<Category> selectPageCategory(Page<Category> pageParam, CategoryQueryDto categoryQueryDto);
}
