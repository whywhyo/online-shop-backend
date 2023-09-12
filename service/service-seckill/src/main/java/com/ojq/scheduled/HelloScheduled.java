package com.ojq.scheduled;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @Author Jinquan_Ou
 * @Description
 * @Date 2023-09-11 18:56
 * @Version 1.0.0
 **/
@EnableScheduling
@Component
public class HelloScheduled {
    //每秒执行一次

    //spring中的cron表达式只能由6位组成，不允许第7位
    //定时任务不应该阻塞，应该把里面的任务放到CompletableFuture异步编排里面，自己提交到线程池上执行

    //还可以用spring自带的异步任务来执行，方法：
    //      1.在类上加上@EnableAsync注解
    //      2.给要异步执行的方法加上@Async注解
    @Scheduled(cron = "* * * * * ? ")
    public void hello(){
        System.out.println("hello");
    }

}
