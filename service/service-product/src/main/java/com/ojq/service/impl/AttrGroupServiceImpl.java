package com.ojq.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ojq.domain.dto.product.AttrGroupQueryDto;
import com.ojq.domain.po.product.AttrGroup;
import com.ojq.mapper.AttrGroupMapper;
import com.ojq.service.AttrGroupService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * <p>
 * 属性分组 服务实现类
 * </p>
 *
 * @author atguigu
 * @since 2023-04-04
 */
@Service
public class AttrGroupServiceImpl extends ServiceImpl<AttrGroupMapper, AttrGroup> implements AttrGroupService {

    //平台属性分组列表
    @Override
    public IPage<AttrGroup> selectPageAttrGroup(Page<AttrGroup> pageParam, AttrGroupQueryDto attrGroupQueryDto) {
        String name = attrGroupQueryDto.getName();
        LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
        if(!StringUtils.isEmpty(name)) {
            wrapper.like(AttrGroup::getName,name);
        }
        IPage<AttrGroup> pageModel = baseMapper.selectPage(pageParam,wrapper);
        return pageModel;
    }

    //查询所有平台属性分组列表
    @Override
    public List<AttrGroup> findAllListAttrGroup() {
       //LambdaQueryWrapper<AttrGroup> wrapper = new LambdaQueryWrapper<>();
        QueryWrapper<AttrGroup> wrapper = new QueryWrapper<>();
        wrapper.orderByDesc("id");
        List<AttrGroup> list = baseMapper.selectList(wrapper);
        return list;
    }
}
