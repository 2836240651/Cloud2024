package com.atguigu.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/9 9:43
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Main8401 {
    public static void main(String[] args) {
        SpringApplication.run(Main8401.class,args);
    }
}
