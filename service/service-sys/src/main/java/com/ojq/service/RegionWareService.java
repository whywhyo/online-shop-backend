package com.ojq.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ojq.domain.po.sys.RegionWare;
import com.ojq.domain.vo.sys.RegionWareQueryVo;

/**
 * <p>
 * 城市仓库关联表 服务类
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
public interface RegionWareService extends IService<RegionWare> {
    //开通区域列表
    IPage<RegionWare> selectPageRegionWare(Page<RegionWare> pageParam, RegionWareQueryVo regionWareQueryVo);

    //添加开通区域
    void saveRegionWare(RegionWare regionWare);

    //取消开通区域
    void updateStatus(Long id, Integer status);

}
