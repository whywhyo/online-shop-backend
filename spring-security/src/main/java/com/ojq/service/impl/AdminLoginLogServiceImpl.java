package com.ojq.service.impl;

import com.ojq.domain.po.acl.AdminLoginLog;
import com.ojq.mapper.AdminLoginLogMapper;
import com.ojq.service.AdminLoginLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 后台用户登录日志表 服务实现类
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Service
public class AdminLoginLogServiceImpl extends ServiceImpl<AdminLoginLogMapper, AdminLoginLog> implements AdminLoginLogService {

}
