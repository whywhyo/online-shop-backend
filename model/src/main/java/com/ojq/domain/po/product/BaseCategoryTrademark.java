package com.ojq.domain.po.product;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 三级分类表
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("base_category_trademark")
@ApiModel(value = "BaseCategoryTrademark对象", description = "三级分类表")
public class BaseCategoryTrademark implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("三级级分类id")
    @TableField("category3_id")
    private Long category3Id;

    @ApiModelProperty("品牌id")
    @TableField("trademark_id")
    private Long trademarkId;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_deleted")
    private Integer isDeleted;


}
