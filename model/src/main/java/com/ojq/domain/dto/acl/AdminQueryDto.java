package com.ojq.domain.dto.acl;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-05 19:47
 * @Version 1.0.0
 **/
@Data
@ApiModel(description = "用户查询实体")
public class AdminQueryDto implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户名")
    private String username;

    @ApiModelProperty(value = "昵称")
    private String name;
}
