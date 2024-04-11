package com.atguigu.cloud.apis;

import com.atguigu.cloud.resp.ResultData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/10 9:25
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@FeignClient(value = "nacos-payment-provider",fallback =PayFeignSentinelApiFallBack.class)
public interface PayFeignSentinelApi {
    @GetMapping("/pay/nacos/get/{orderNo}")
    public ResultData getPayByOrderNo(@PathVariable("orderNo") String orderNo);
}
