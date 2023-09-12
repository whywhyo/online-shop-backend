package com.ojq.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ojq.domain.po.sys.Region;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 地区表 Mapper 接口
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
@Mapper
public interface RegionMapper extends BaseMapper<Region> {

}
