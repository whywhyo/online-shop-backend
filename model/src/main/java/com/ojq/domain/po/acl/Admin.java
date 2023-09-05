package com.ojq.domain.po.acl;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.ojq.domain.po.base.BaseEntity;
import com.ojq.validation.anno.PasswordConstraint;
import com.ojq.validation.group.RegisterGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author ojq
 * @since 2023年07月09日
 */

@TableName("admin")
@ApiModel(value = "Admin对象", description = "用户表")
@Data
public class Admin extends BaseEntity implements Serializable {
    private static final long serialVersionUID = 1L;

//    @ApiModelProperty("会员id")
//    @TableId(value = "id", type = IdType.AUTO)
//    private Long id;


    @NotBlank(message = "用户名不能为空",groups = {RegisterGroup.class})
    @ApiModelProperty("用户名")
    @TableField("username")
    private String username;


    @ApiModelProperty("密码")
    @PasswordConstraint(groups = {RegisterGroup.class})
    @TableField("password")
    private String password;

    @ApiModelProperty("姓名")
    @TableField("name")
    private String name;

    @ApiModelProperty("手机")
    @TableField("phone")
    private String phone;

    @ApiModelProperty("仓库id（默认为：0为平台用户）")
    @TableField("ware_id")
    private Long wareId;

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
