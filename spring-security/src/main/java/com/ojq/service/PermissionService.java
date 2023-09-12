package com.ojq.service;

import com.ojq.domain.po.acl.Permission;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ojq.domain.vo.acl.PermissionTreeVo;

import java.util.List;

/**
 * <p>
 * 权限 服务类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
public interface PermissionService extends IService<Permission> {

    //获取所有菜单列表
    List<PermissionTreeVo> queryAllMenu();

    //递归删除
    boolean removeChildById(Long id);

}
