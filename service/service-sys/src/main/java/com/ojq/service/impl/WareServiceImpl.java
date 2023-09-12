package com.ojq.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ojq.domain.po.sys.Ware;
import com.ojq.mapper.WareMapper;
import com.ojq.service.WareService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 仓库表 服务实现类
 * </p>
 *
 * @author ojq
 * @since 2023-09-11
 */
@Service
public class WareServiceImpl extends ServiceImpl<WareMapper, Ware> implements WareService {

}
