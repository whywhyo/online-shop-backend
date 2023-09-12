package com.ojq.domain.dto.es;

import lombok.Data;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 18:41
 * @Version 1.0.0
 **/
@Data
public class SkuEsQueryDto {
    private Long categoryId;;//三级分类id

    private String keyword;//检索的关键字

    private Long wareId;
}
