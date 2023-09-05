package com.ojq.domain.po.sys;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ojq.domain.po.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * <p>
 * 地区表
 * </p>
 *
 * @author ojq
 * @since 2023年07月04日
 */
@Getter
@Setter
@TableName("region")
@ApiModel(value = "Region对象", description = "地区表")
public class Region extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("上级id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;




}
