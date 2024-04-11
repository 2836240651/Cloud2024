package com.atguigu.cloud.controller;

import com.atguigu.cloud.entities.PayDTO;
import com.atguigu.cloud.resp.ResultData;
import jakarta.annotation.Resource;
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
    public static final String PaymentSrv_URL = "http://cloud-payment-service";
/*    public static final String PaymentSrv_URL = "http://localhost:8001";*/
    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/consumer/pay/add")
    public ResultData addOder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentSrv_URL + "/pay/add", payDTO, ResultData.class);
    }
    @GetMapping("/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/get/" + id, ResultData.class, id);

    }
    @DeleteMapping("/consumer/pay/del/{id}")
    public ResultData deletePayById(@PathVariable("id")Integer id){
        return restTemplate.exchange(PaymentSrv_URL + "/pay/del" + id, HttpMethod.DELETE, null, ResultData.class).getBody();
    }
    @PutMapping("consumer/pay/update")
    public ResultData updateOrder(PayDTO payDTO){
        return restTemplate.exchange(PaymentSrv_URL + "/pay/update", HttpMethod.PUT, new HttpEntity<>(payDTO), ResultData.class).getBody();
    }
    @GetMapping("consumer/pay/getall")
    public ResultData getAll(){
        return restTemplate.getForObject(PaymentSrv_URL + "/pay/getall", ResultData.class);

    }
    @GetMapping("consumer/pay/get/info")
    private String getInfoByConsul(){
        return restTemplate.getForObject(PaymentSrv_URL+"/pay/info",String.class);
    }
    @Resource
    private DiscoveryClient discoveryClient;
    @GetMapping("consumer/discove")
    public Object getClient(){
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            System.out.println(service);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("cloud-payment-service");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort());
        }
        return instances.get(0).getPort();
    }
}
