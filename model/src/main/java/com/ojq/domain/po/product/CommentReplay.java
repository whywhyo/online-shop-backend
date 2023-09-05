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
 * 产品评价回复表
 * </p>
 *
 * @author ojq
 * @since 2023年07月03日
 */
@Getter
@Setter
@TableName("comment_replay")
@ApiModel(value = "CommentReplay对象", description = "产品评价回复表")
public class CommentReplay implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField("comment_id")
    private Long commentId;

    @TableField("nick_name")
    private String nickName;

    @TableField("icon")
    private String icon;

    @TableField("content")
    private String content;

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
