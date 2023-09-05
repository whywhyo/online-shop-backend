package com.ojq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ojq.domain.dto.acl.RoleQueryDto;
import com.ojq.domain.po.acl.Admin;
import com.ojq.domain.po.acl.Role;
import com.ojq.mapper.RoleMapper;
import com.ojq.service.RoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ojq.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 * @author ojq
 * @since 2023-09-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    /**
     * 根据用户id获取角色数据
     * @return
     */
    @Override
    public Map<String, Object> findRoleByUserId() {

        //获取当前用户id
        Long userId = SecurityUtils.getLoginUserId();

        //查询所有角色
        List<Role> addRole = list();

        return null;

    }

    @Override
    public Map<String, Object> selectAllRoleByPage(Long current, Long limit, RoleQueryDto roleQueryDto) {
        LambdaQueryWrapper<Role> lqw = new LambdaQueryWrapper<Role>().like(!StringUtils.isEmpty(roleQueryDto.getRoleName()), Role::getRoleName, roleQueryDto.getRoleName());
        Page<Role> pageObject = new Page<>(current, limit);
        Page<Role> pageData = page(pageObject, lqw);
        return getResultMap(pageData);
    }

    /**
     * 分页返回数据的map封装
     * @param pageData
     * @return
     */
    private static HashMap<String, Object> getResultMap(Page<Role> pageData) {
        HashMap<String, Object> resultData = new HashMap<>();
        resultData.put("pageNum", pageData.getCurrent());
        resultData.put("pageSize", pageData.getSize());
        resultData.put("total", pageData.getTotal());
        resultData.put("data", pageData.getRecords());
        return resultData;
    }


}
