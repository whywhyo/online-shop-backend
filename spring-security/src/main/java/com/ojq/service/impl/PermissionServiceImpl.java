package com.ojq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.ojq.domain.po.acl.Permission;
import com.ojq.domain.vo.acl.PermissionTreeVo;
import com.ojq.mapper.PermissionMapper;
import com.ojq.service.PermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 权限 服务实现类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements PermissionService {
    //获取所有菜单
    @Override
    public List<PermissionTreeVo> queryAllMenu() {
        //获取全部权限数据
        List<Permission> allPermissionList = baseMapper.selectList(new QueryWrapper<Permission>().orderByAsc("CAST(id AS SIGNED)"));

        //把权限数据构建成树形结构数据
        return allPermissionList.stream().filter(permission -> {
                    return permission.getPid() == 0;
                })
                .map(permission -> {
                    PermissionTreeVo permissionTreeVo = new PermissionTreeVo();
                    BeanUtils.copyProperties(permission, permissionTreeVo);
                    permissionTreeVo.setChildList(fillChildList(permission, allPermissionList));
                    return permissionTreeVo;
                }).collect(Collectors.toList());
    }


    /**
     * 递归查找权限菜单的子菜单
     * @param father
     * @param allPermissionList
     * @return
     */
    private List<PermissionTreeVo> fillChildList(Permission father, List<Permission> allPermissionList) {
        return allPermissionList.stream().filter(permission -> permission.getPid() == father.getId())
                .map(permission -> {
                    PermissionTreeVo permissionTreeVo = new PermissionTreeVo();
                    BeanUtils.copyProperties(permission, permissionTreeVo);
                    permissionTreeVo.setChildList(fillChildList(permission, allPermissionList));
                    return permissionTreeVo;
                }).collect(Collectors.toList());

    }

    //递归删除菜单
    @Override
    public boolean removeChildById(Long id) {
        List<Long> idList = new ArrayList<>();
        this.selectChildListById(id, idList);
        idList.add(id);
        baseMapper.deleteBatchIds(idList);
        return true;
    }

    /**
     *	递归获取子节点
     * @param id
     * @param idList
     */
    private void selectChildListById(Long id, List<Long> idList) {
        List<Permission> childList = baseMapper.selectList(new QueryWrapper<Permission>().eq("pid", id).select("id"));
        childList.stream().forEach(item -> {
            idList.add(item.getId());
            this.selectChildListById(item.getId(), idList);
        });
    }

}
