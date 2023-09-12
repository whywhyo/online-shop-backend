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
 * @Date 2023-09-12 12:32
 * @Version 1.0.0
 **/
@Data
public class SkuInfoDto extends SkuInfo {
    @ApiModelProperty(value = "海报列表")
    private List<SkuPoster> skuPosterList;

    @ApiModelProperty(value = "属性值列表")
    private List<SkuAttrValue> skuAttrValueList;

    @ApiModelProperty(value = "图片列表")
    private List<SkuImage> skuImagesList;
}
