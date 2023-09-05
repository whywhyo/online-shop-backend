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
 * 商品三级分类
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("category")
@ApiModel(value = "Category对象", description = "商品三级分类")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("分类id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("分类名称")
    @TableField("name")
    private String name;

    @TableField("img_url")
    private String imgUrl;

    @ApiModelProperty("父分类id")
    @TableField("parent_id")
    private Long parentId;

    @ApiModelProperty("是否显示[0-不显示，1显示]")
    @TableField("status")
    private Integer status;

    @ApiModelProperty("排序")
    @TableField("sort")
    private Integer sort;

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
