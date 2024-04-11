package com.atguigu.cloud.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/9 21:09
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@RestController
public class hotSpotController {
@GetMapping("/hotKey")
    @SentinelResource(value = "hotkey",blockHandler = "hotkeyHandler")
    public String getHot(@RequestParam(value = "p1",required = false)String  p1,
                         @RequestParam(value = "p2",required = false)String  p2){
    return "----testHotKey!!";
}
public String hotkeyHandler(String p1, String p2, BlockException exception){
    return "hotKey访问太多被限流了老弟！！";
}

}
