package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.resp.ReturnCodeEnum;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

/**
 * @auther zzyy
 * @create 2023-11-23 17:09
 */
@RestController
public class PayAlibabaController
{
    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/pay/nacos/{id}")
    public String getPayInfo(@PathVariable("id") Integer id)
    {
        return "nacos registry, serverPort: "+ serverPort+"\t id"+id;
    }
    @GetMapping(value = "pay/nacos/get/{orderNo}")
    @SentinelResource(value = "getPayByOrderNo",blockHandler = "handlerBlocker")
    public ResultData getPayByOrderNo(@PathVariable("orderNo")String orderNo){
        PayDTO payDTO =new PayDTO();
        payDTO.setId(1024);
        payDTO.setOrderNo(orderNo);
        payDTO.setPayNo("pay:"+ IdUtil.fastUUID());
        payDTO.setAmount(BigDecimal.valueOf(9.99));
        return ResultData.success("查询返回 ：" +payDTO);
    }
    public ResultData handlerBlocker(String orderNo, BlockException blockException){
        return ResultData.fail(ReturnCodeEnum.RC500.getCode(), "getbyoderseriver not use" +
                "触发sentinel流控配置规则"+"\t"+"o(╥﹏╥)o");
    }
}