package com.ojq.validation;

import com.ojq.validation.anno.PasswordConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-05 20:25
 * @Version 1.0.0
 **/
public class PasswordValidator implements ConstraintValidator<PasswordConstraint, String> {
    @Override
    public boolean isValid(String password, ConstraintValidatorContext constraintValidatorContext) {
        if (password == null) {
            return false;
        }
        return password.matches(".*[a-z].*") && password.matches(".*[A-Z].*");
    }
}
