package com.ojq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ojq.domain.po.sys.Ware;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 仓库表 Mapper 接口
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
@Mapper
public interface WareMapper extends BaseMapper<Ware> {

}
