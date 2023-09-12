package com.ojq.domain.dto.acl;

import com.ojq.domain.po.product.SkuAttrValue;
import com.ojq.domain.po.product.SkuImage;
import com.ojq.domain.po.product.SkuInfo;
import com.ojq.domain.po.product.SkuPoster;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 11:48
 * @Version 1.0.0
 **/
@Data
public class SkuInfoQueryDto {
    @ApiModelProperty(value = "分类id")
    private Long categoryId;

    @ApiModelProperty(value = "商品类型：0->普通商品 1->秒杀商品")
    private String skuType;

    @ApiModelProperty(value = "spu名称")
    private String keyword;
}
