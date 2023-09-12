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
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * sku信息
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("sku_info")
@ApiModel(value = "SkuInfo对象", description = "sku信息")
public class SkuInfo implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("分类id")
    @TableField("category_id")
    private Long categoryId;

    @ApiModelProperty("平台属性分组id")
    @TableField("attr_group_id")
    private Long attrGroupId;

    @ApiModelProperty("商品类型：0->普通商品 1->秒杀商品")
    @TableField("sku_type")
    private Integer skuType;

    @ApiModelProperty("sku名称")
    @TableField("sku_name")
    private String skuName;

    @ApiModelProperty("展示图片")
    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("限购个数/每天（0：不限购）")
    @TableField("per_limit")
    private Integer perLimit;

    @ApiModelProperty("上架状态：0->下架；1->上架")
    @TableField("publish_status")
    private Integer publishStatus;

    @ApiModelProperty("审核状态：0->未审核；1->审核通过")
    @TableField("check_status")
    private Integer checkStatus;

    @ApiModelProperty("是否新人专享：0->否；1->是")
    @TableField("is_new_person")
    private Integer newPerson;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

    @ApiModelProperty("sku编码")
    @TableField("sku_code")
    private String skuCode;

    @ApiModelProperty("价格")
    @TableField("price")
    private BigDecimal price;

    @ApiModelProperty("市场价")
    @TableField("market_price")
    private BigDecimal marketPrice;

    @ApiModelProperty("库存")
    @TableField("stock")
    private Integer stock;

    @ApiModelProperty("锁定库存")
    @TableField("lock_stock")
    private Integer lockStock;

    @ApiModelProperty("预警库存")
    @TableField("low_stock")
    private Integer lowStock;

    @ApiModelProperty("销量")
    @TableField("sale")
    private Integer sale;

    @ApiModelProperty("仓库")
    @TableField("ware_id")
    private Long wareId;

    @TableField("version")
    private Long version;

    @ApiModelProperty("创建时间")
    @TableField("create_time")
    private LocalDateTime createTime;

    @ApiModelProperty("更新时间")
    @TableField("update_time")
    private LocalDateTime updateTime;

    @ApiModelProperty("删除标记（0:不可用 1:可用）")
    @TableField("is_deleted")
    private Integer isDeleted;


}
