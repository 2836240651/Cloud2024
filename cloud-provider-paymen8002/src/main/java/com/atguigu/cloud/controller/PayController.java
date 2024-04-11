package com.atguigu.cloud.controller;

import cn.hutool.core.bean.BeanUtil;
import com.atguigu.cloud.entities.Pay;
import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import com.atguigu.cloud.service.PayService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/1 21:06
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@Slf4j
@RestController
@Tag(name = "支付微服务模块",description = "支付CRUD")
public class PayController {
@Resource
    private PayService payService;
@PostMapping(value = "/pay/add")
 @Operation(summary="新增",description = "新增支付流水方,json串做参数")
    public ResultData addPay(@RequestBody Pay pay){
    System.out.println(pay.toString());
    int add = payService.add(pay);
    return ResultData.success("成功插入记录,返回值是:"+add);
}
@DeleteMapping(value = "pay/del/{id}")
@Operation(summary = "删除",description = "删除支付流水方法")
    public ResultData deletePay(@PathVariable("id") Integer id){
    int delete = payService.delete(id);
    return ResultData.success(delete);
}

@PutMapping(value = "pay/update")
@Operation(summary = "修改",description = "修改支付流水方法")
    public ResultData updatePay(@RequestBody PayDTO payDTO){
    Pay pay = new Pay();
    BeanUtil.copyProperties(payDTO,pay);
    int update = payService.update(pay);
    return ResultData.success("成功修改记录,返回值 :"+update);
}
    @GetMapping(value = "pay/get/{id}")
    @Operation(summary = "按照ID查流水",description = "查询支付流水方法")
    public ResultData getById(@PathVariable("id") Integer id){
        if (id<0){
            throw new RuntimeException("id不能为负数");
        }
        try {
            TimeUnit.SECONDS.sleep(62);
        }catch (InterruptedException e) {e.printStackTrace();}
        Pay pay = payService.getById(id);
        return ResultData.success(pay);
    }
@GetMapping(value ="pay/getall")
@Operation(summary = "获取全部账单",description ="查询全部流水方法" )
    public ResultData getAll(){
    List<Pay> list = payService.getAll();
    List<Map<String,Object>> paylist = new ArrayList<>();
    for (Pay pay : list) {
        Map<String,Object> MapPay = new HashMap<>();
        MapPay.put("number",pay.getPayNo());
        MapPay.put("amount",pay.getAmount());
        MapPay.put("order",pay.getOrderNo());
        MapPay.put("userId",pay.getUserId());
        paylist.add(MapPay);
    }
    return ResultData.success(paylist);
}
@GetMapping(value = "pay/port")
public String getPort(){
    return port;
}
@Value("${server.port}")
private String port;
@GetMapping(value = "pay/info")
    public String getInfo(@Value("${atguigu.info}") String info){
    return "atguiguinfo:"+info+"\n"+"port:"+port;
}
}
