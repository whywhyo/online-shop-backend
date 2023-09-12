package com.ojq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author Jinquan_Ou
 * @Description 开启定时任务和异步任务的配置类
 * @Date 2023-09-11 19:31
 * @Version 1.0.0
 **/
@EnableScheduling
@EnableAsync
@Configuration
public class ScheduleConfig {
}
