package com.ojq.service;

import com.ojq.domain.po.acl.Admin;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
public interface AdminService extends IService<Admin> {
    List<String> findUserPermsList(Long userId);

    Admin getUserByUsername(String username);

}
