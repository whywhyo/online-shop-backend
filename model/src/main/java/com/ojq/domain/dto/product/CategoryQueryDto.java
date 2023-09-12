package com.ojq.domain.dto.product;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 11:36
 * @Version 1.0.0
 **/
@Data
public class CategoryQueryDto {
    @ApiModelProperty(value = "分类名称")
    private String name;
}
