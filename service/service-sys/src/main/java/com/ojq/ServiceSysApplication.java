package com.ojq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-07-04 18:14
 * @Version 1.0.0
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceSysApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceSysApplication.class,args);
    }
}
