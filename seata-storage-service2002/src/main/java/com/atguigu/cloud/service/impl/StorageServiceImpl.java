package com.atguigu.cloud.service.impl;

import cn.hutool.log.Log;
import com.atguigu.cloud.mapper.StorageMapper;
import com.atguigu.cloud.service.StorageService;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/11 11:21
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@Service
@Slf4j
public class StorageServiceImpl implements StorageService {
    @Resource
    StorageMapper storageMapper;
    @Override
    public void decrease(Long productId, Integer count) {
        log.info("------->storage-service中扣减库存开始");
        storageMapper.decrease(productId, count);
        log.info("------->storage-service中扣减库存结束");
    }
}
