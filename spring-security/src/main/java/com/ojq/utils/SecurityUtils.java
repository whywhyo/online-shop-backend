package com.ojq.utils;


import com.ojq.custom.CustomUser;
import com.ojq.domain.po.acl.Admin;
import com.ojq.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-05 17:01
 * @Version 1.0.0
 **/
public class SecurityUtils {

    public static List<String> ignorePathList = Arrays.asList("/favicon.ico","/swagger-resources/", "/webjars/", "/v2/", "/swagger-ui.html/", "/doc.html", "/v2/api-docs","/admin/system/index/login","/admin/user/save");


    /**
     * 获取用户
     **/
    public static Admin getLoginUser()
    {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return (Admin)authentication.getPrincipal();
    }


    /**
     * 获取用户Id
     **/
    public static Long getLoginUserId()
    {
        return getLoginUser().getId();
    }

    public static List<String> getIgnorePathList(){
        return ignorePathList;
    }


}
