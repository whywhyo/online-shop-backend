package com.ojq.service.impl;

import com.ojq.custom.CustomUser;
import com.ojq.domain.po.acl.Admin;
import com.ojq.exception.MyException;
import com.ojq.service.AdminService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

import java.util.stream.Collectors;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-04 19:33
 * @Version 1.0.0
 **/

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    @Resource
    private AdminService adminService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin user = adminService.getUserByUsername(username);
        if(null == user) {
            throw new UsernameNotFoundException("用户名不存在！");
        }

        //如果已经找到用户，那就查找该用户的权限，顺便放进去
        List<String> userPermsList = adminService.findUserPermsList(user.getId());
        List<SimpleGrantedAuthority> authorityList = userPermsList.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList());
        return new CustomUser(user, authorityList);
    }
}
