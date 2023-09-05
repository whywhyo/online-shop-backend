package com.ojq.domain.po.sys;

import com.baomidou.mybatisplus.annotation.*;
import com.ojq.domain.po.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 城市仓库关联表
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("region_ware")
@ApiModel(value = "仓库-地区对象", description = "城市仓库关联表")
public class RegionWare extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "开通区域")
    @TableField("region_id")
    private Long regionId;

    @ApiModelProperty(value = "区域名称")
    @TableField("region_name")
    private String regionName;

    @ApiModelProperty(value = "仓库")
    @TableField("ware_id")
    private Long wareId;

    @ApiModelProperty(value = "仓库名称")
    @TableField("ware_name")
    private String wareName;

    @ApiModelProperty(value = "状态（0：未开通 1：已开通）")
    @TableField("status")
    private Integer status;

}
