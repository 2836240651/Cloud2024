package com.atguigu.cloud.service;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/9 10:23
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@Service
public class FlowLimitService {
@SentinelResource(value = "common")
    public void common(){
    System.out.println("------FLOWLIMIT SERVICE COME IN !!");
}
}
