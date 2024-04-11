package com.atguigu.cloud.controller;

import com.atguigu.cloud.apis.PayFeignApi;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/6 16:20
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@RestController
@Slf4j
public class orderGatewayController {
    @Resource
    PayFeignApi payFeignApi;
@GetMapping(value = "/feign/gateway/{id}")
    public ResultData gateway(@PathVariable("id")Integer id){
    ResultData byId = payFeignApi.getById(id);
    return byId;

}
@GetMapping(value = "feign/gateway/info")
    public ResultData<String> getGateinfo(){
    ResultData<String> gatewayInfo = payFeignApi.getGatewayInfo();
    return gatewayInfo;
}
}
