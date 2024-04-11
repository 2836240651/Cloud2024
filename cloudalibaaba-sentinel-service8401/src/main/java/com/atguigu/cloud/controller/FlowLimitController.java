package com.atguigu.cloud.controller;

import com.atguigu.cloud.service.FlowLimitService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/9 9:49
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@RestController
public class FlowLimitController {
    @Resource private FlowLimitService flowLimitService;
@GetMapping("/testA")
    public String testA(){
    return "----testA!!";
}
@GetMapping("/testB")
public String testB(){
    return "----testB!!";
}
    @GetMapping("/testC")
    public String testC()
    {
        flowLimitService.common();
        return "------testC";
    }
    @GetMapping("/testD")
    public String testD()
    {
        flowLimitService.common();
        return "------testD";
    }
    @GetMapping("/testE")
    public String testE(){
        System.out.println(System.currentTimeMillis()+"-----排队");
        return "------E";
    }
    @GetMapping("/testG")
    public String testG(){
try {
    TimeUnit.SECONDS.sleep(1);
}catch (InterruptedException e){e.printStackTrace();};
        System.out.println("测试慢调用，熔断；");
        return "---testGmandioyong1";
}
@GetMapping("/testF")
    public String testF(){
    int d = 10/0;
    return "------testF(异常比例)";
}
@GetMapping("/testO")
    public String testO(){
    int p=10/0;
    return "------testO(异常数)";
}
}
