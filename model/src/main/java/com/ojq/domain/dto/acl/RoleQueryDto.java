package com.ojq.domain.dto.acl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-04 15:43
 * @Version 1.0.0
 **/
@Data
@ApiModel(description = "角色查询条件")
public class RoleQueryDto implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "角色名称")
    private String roleName;
}
