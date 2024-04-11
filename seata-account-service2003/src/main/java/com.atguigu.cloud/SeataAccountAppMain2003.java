package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/11 11:31
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@MapperScan("com.atguigu.cloud.mapper")
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class SeataAccountAppMain2003 {
    public static void main(String[] args) {
        SpringApplication.run(SeataAccountAppMain2003.class,args);
    }
}
