package com.ojq.mapper;

import com.ojq.domain.po.acl.Permission;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 权限 Mapper 接口
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Mapper
public interface PermissionMapper extends BaseMapper<Permission> {

}
