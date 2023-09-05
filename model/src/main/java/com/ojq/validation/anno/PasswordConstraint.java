package com.ojq.validation.anno;

import com.ojq.validation.PasswordValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author Jinquan_Ou
 * @Description 自定义注解，实现密码校验
 * @Date 2023-09-05 20:20
 * @Version 1.0.0
 **/

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PasswordValidator.class)
public @interface PasswordConstraint {

    String message() default "密码必须要有大写和小写字母";

    //groups属性，用于指定验证分组，可以为不同的验证场景定义不同的分组
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
