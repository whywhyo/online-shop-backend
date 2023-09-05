package com.ojq.mapper;

import com.ojq.domain.po.acl.Admin;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author ojq
 * @since 2023-09-04
 */
@Mapper
public interface AdminMapper extends BaseMapper<Admin> {

    List<String> findUserPermsListByUserId(Long userId);

}
