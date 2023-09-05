package com.ojq.encoder;

import com.ojq.utils.MD5Encoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * @Author Jinquan_Ou
 * @Description 使用自定义的MD5密码加密解密方法
 * @Date 2023-07-09 12:57
 * @Version 1.0.0
 **/

@Component
public class MD5PasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence rawPassword) {
        return MD5Encoder.encrypt(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence rawPassword, String encodedPassword) {
        return encodedPassword.equals(MD5Encoder.encrypt(rawPassword.toString()));
    }
}
