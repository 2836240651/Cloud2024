package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/4 10:34
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
public class MainOpenFeign80 {
    public static void main(String[] args) {
        SpringApplication.run(MainOpenFeign80.class,args);
        
    }
}
