package com.ojq.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ojq.domain.po.sys.Region;

import java.util.List;

/**
 * <p>
 * 地区表 服务类
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
public interface RegionService extends IService<Region> {

    List<Region> findRegionByKeyword(String keyword);
}
