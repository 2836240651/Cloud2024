package com.atguigu.cloud;

import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/1 20:36
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.atguigu.cloud.mapper")
public class Main8001 {
    public static void main(String[] args) {
        SpringApplication.run(Main8001.class);
    }
}
