package com.ojq.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ojq.domain.po.acl.Admin;
import com.ojq.mapper.AdminMapper;
import com.ojq.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {

    @Resource
    AdminMapper adminMapper;

    @Override
    public List<String> findUserPermsList(Long userId) {
        List<String> userPermsList = adminMapper.findUserPermsListByUserId(userId);
        if (userPermsList == null || userPermsList.isEmpty()){
            throw new RuntimeException("该用户无权限操作，请联系管理员");
        }
        return userPermsList;
    }

    @Override
    public Admin getUserByUsername(String username) {
        LambdaQueryWrapper<Admin> lqw = new LambdaQueryWrapper<Admin>().eq(!StringUtils.isEmpty(username), Admin::getUsername, username);
        Admin user = getOne(lqw);
        return user;
    }
}
