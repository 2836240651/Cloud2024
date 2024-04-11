package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/2 15:06
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Main80 {
    public static void main(String[] args) {
        SpringApplication.run(Main80.class,args);
    }
}
