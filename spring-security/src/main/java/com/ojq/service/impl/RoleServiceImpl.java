package com.ojq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ojq.domain.dto.acl.RoleQueryDto;
import com.ojq.domain.po.acl.Role;
import com.ojq.mapper.RoleMapper;
import com.ojq.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Override
    public IPage<Role> selectPage(Page<Role> pageParam, RoleQueryDto roleQueryDto) {
        LambdaQueryWrapper<Role> lqw = new LambdaQueryWrapper<Role>()
                .like(!StringUtils.isEmpty(roleQueryDto.getRoleName()), Role::getRoleName, roleQueryDto.getRoleName());
        return page(pageParam, lqw);
    }


}
