package com.atguigu.cloud.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.io.unit.DataUnit;
import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import jakarta.annotation.Resource;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/2 21:47
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@Slf4j
@RestController
public class OderController {
@Resource
    private PayFeignApi payFeignApi;
@PostMapping("/feign/pay/add")
    public ResultData feignAdd(@RequestBody PayDTO payDTO){
    ResultData resultData = payFeignApi.addPay(payDTO);
    return resultData;
}
@GetMapping("/feign/pay/get/{id}")
    public ResultData feignGet(@PathVariable("id") Integer id){
    ResultData resultData = null;
    try {
        System.out.println("调用开始---:"+ DateUtil.now());
       resultData= payFeignApi.getPayInfo(id);
    }catch (Exception e){e.printStackTrace();
        System.out.println("调用结束---:"+DateUtil.now());
        resultData.fail(ReturnCodeEnum.RC500.getCode(), e.getMessage());
    }
    return resultData;
}
@GetMapping("/feign/pay/get/info")
    public String feignInfo(){
    String  mylb = payFeignApi.mylb();
    return mylb;
}
@GetMapping("feign/pay/port")
    public String getPort(){
    String port = payFeignApi.port();
    return port;
}
}
