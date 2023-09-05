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
 * 角色
 * </p>
 *
 * @author ojq
 * @since 2023年07月09日
 */
@Data
@TableName("role")
@ApiModel(value = "Role对象", description = "角色")
public class Role extends BaseEntity implements Serializable {

    private static final long serialVersionUID = 1L;

//    @ApiModelProperty("角色id")
//    @TableId(value = "id", type = IdType.AUTO)
//    private Long id;

    @ApiModelProperty("角色名称")
    @TableField("role_name")
    private String roleName;

    @ApiModelProperty("角色编码")
    @TableField("role_code")
    private String roleCode;

    @ApiModelProperty("备注")
    @TableField("remark")
    private String remark;

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
