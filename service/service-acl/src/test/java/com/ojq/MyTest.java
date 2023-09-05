package com.ojq;


import com.ojq.service.impl.AdminServiceImpl;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-07-10 12:31
 * @Version 1.0.0
 **/
@SpringBootTest
public class MyTest {
    @Autowired
    private AdminServiceImpl adminService;

    @Test
    public void test1(){
        System.out.println(adminService.findUserPermsList(1L));
    }

}
