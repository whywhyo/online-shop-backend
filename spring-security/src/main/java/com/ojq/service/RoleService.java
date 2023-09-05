package com.ojq.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ojq.domain.dto.acl.RoleQueryDto;
import com.ojq.domain.po.acl.Role;


/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
public interface RoleService extends IService<Role> {

    IPage<Role> selectPage(Page<Role> pageParam, RoleQueryDto roleQueryDto);
}
