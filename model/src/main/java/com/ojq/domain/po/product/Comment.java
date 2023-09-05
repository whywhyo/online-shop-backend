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
 * 商品评价
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("comment")
@ApiModel(value = "Comment对象", description = "商品评价")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty("sku_id")
    @TableField("sku_id")
    private Long skuId;

    @ApiModelProperty("商品名字")
    @TableField("sku_name")
    private String skuName;

    @ApiModelProperty("会员昵称")
    @TableField("nick_name")
    private String nickName;

    @ApiModelProperty("用户头像")
    @TableField("icon")
    private String icon;

    @ApiModelProperty("星级")
    @TableField("star")
    private Boolean star;

    @ApiModelProperty("会员ip")
    @TableField("ip")
    private String ip;

    @ApiModelProperty("显示状态[0-不显示，1-显示]")
    @TableField("status")
    private Boolean status;

    @ApiModelProperty("点赞数")
    @TableField("follow_count")
    private Integer followCount;

    @ApiModelProperty("回复数")
    @TableField("reply_count")
    private Integer replyCount;

    @ApiModelProperty("评论图片/视频[json数据；[{type:文件类型,url:资源路径}]]")
    @TableField("resources")
    private String resources;

    @ApiModelProperty("内容")
    @TableField("content")
    private String content;

    @ApiModelProperty("评论类型[0 - 对商品的直接评论，1 - 对评论的回复]")
    @TableField("type")
    private Integer type;

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
