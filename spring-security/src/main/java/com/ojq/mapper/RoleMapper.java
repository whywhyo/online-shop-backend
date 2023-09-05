package com.ojq.mapper;

import com.ojq.domain.po.acl.Role;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Mapper
public interface RoleMapper extends BaseMapper<Role> {

}
