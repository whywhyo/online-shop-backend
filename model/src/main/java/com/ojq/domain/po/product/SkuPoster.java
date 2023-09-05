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
 * 商品海报表
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("sku_poster")
@ApiModel(value = "SkuPoster对象", description = "商品海报表")
public class SkuPoster implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("编号")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("商品id")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty("文件名称")
    @TableField("img_name")
    private String imgName;

    @ApiModelProperty("文件路径")
    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @TableField("update_time")
    private LocalDateTime updateTime;

    @TableField("is_deleted")
    private Integer isDeleted;


}
