package com.ojq.custom;

import com.ojq.domain.po.acl.Admin;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * @Author Jinquan_Ou
 * @Description spring-security的用户对象
 * @Date 2023-07-09 13:17
 * @Version 1.0.0
 **/
public class CustomUser extends User {

    //自己的用户对象
    private Admin admin;

    public CustomUser(Admin admin, Collection<? extends GrantedAuthority> authorities) {
        super(admin.getUsername(), admin.getPassword(), authorities);
        this.admin = admin;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

}
