package com.ojq.domain.dto.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 11:42
 * @Version 1.0.0
 **/
@Data
public class AttrGroupQueryDto {
    @ApiModelProperty(value = "组名")
    private String name;
}
