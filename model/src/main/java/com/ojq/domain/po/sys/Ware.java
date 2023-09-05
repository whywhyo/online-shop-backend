package com.ojq.domain.po.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ojq.domain.po.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * <p>
 * 仓库表
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("ware")
@ApiModel(value = "Ware对象", description = "仓库表")
public class Ware extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("省code")
    @TableField("province")
    private String province;

    @ApiModelProperty("城市code")
    @TableField("city")
    private String city;

    @ApiModelProperty("区域code")
    @TableField("district")
    private String district;

    @ApiModelProperty("详细地址")
    @TableField("detail_address")
    private String detailAddress;

    @ApiModelProperty("经度")
    @TableField("longitude")
    private BigDecimal longitude;

    @ApiModelProperty("纬度")
    @TableField("latitude")
    private BigDecimal latitude;


}
