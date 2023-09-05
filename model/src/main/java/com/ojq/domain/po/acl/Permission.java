package com.ojq.domain.po.acl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ojq.domain.po.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 权限
 * </p>
 *
 * @author ojq
 * @since 2023年07月09日
 */
@Data
@TableName("permission")
@ApiModel(value = "Permission对象", description = "权限")
public class Permission extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty("编号")
//    @TableId(value = "id", type = IdType.AUTO)
//    private Long id;

    @ApiModelProperty("所属上级")
    @TableField("pid")
    private Long pid;

    @ApiModelProperty("名称")
    @TableField("name")
    private String name;

    @ApiModelProperty("名称code")
    @TableField("code")
    private String code;

    @ApiModelProperty("跳转页面code")
    @TableField("to_code")
    private String toCode;

    @ApiModelProperty("类型(1:菜单,2:按钮)")
    @TableField("type")
    private Integer type;

    @ApiModelProperty("状态(0:禁止,1:正常)")
    @TableField("status")
    private Integer status;

//    @ApiModelProperty("创建时间")
//    @TableField("create_time")
//    private LocalDateTime createTime;
//
//    @ApiModelProperty("更新时间")
//    @TableField("update_time")
//    private LocalDateTime updateTime;
//
//    @ApiModelProperty("删除标记（0:不可用 1:可用）")
//    @TableField("is_deleted")
//    private Integer isDeleted;


}
