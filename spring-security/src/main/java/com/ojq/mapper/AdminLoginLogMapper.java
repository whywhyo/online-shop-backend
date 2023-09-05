package com.ojq.mapper;

import com.ojq.domain.po.acl.AdminLoginLog;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 后台用户登录日志表 Mapper 接口
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Mapper
public interface AdminLoginLogMapper extends BaseMapper<AdminLoginLog> {

}
