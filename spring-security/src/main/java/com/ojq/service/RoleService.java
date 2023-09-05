package com.ojq.service;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ojq.domain.dto.acl.RoleQueryDto;
import com.ojq.domain.po.acl.Role;

import java.util.Map;


/**
 * <p>
 * 角色 服务类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
public interface RoleService extends IService<Role> {


    Map<String, Object> findRoleByUserId();

    Map<String, Object> selectAllRoleByPage(Long current, Long limit, RoleQueryDto roleQueryDto);
}
