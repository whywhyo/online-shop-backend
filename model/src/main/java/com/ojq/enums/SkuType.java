package com.ojq.enums;

import com.baomidou.mybatisplus.annotation.EnumValue;
import lombok.Getter;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-12 18:49
 * @Version 1.0.0
 **/
@Getter
public enum SkuType {
    COMMON(0,"普通"),
    SECKILL(1,"秒杀" );

    @EnumValue
    private Integer code ;
    private String comment ;

    SkuType(Integer code, String comment ){
        this.code=code;
        this.comment=comment;
    }
}
