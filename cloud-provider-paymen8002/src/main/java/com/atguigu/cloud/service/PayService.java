package com.atguigu.cloud.service;

import com.atguigu.cloud.entities.Pay;

import java.util.List;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/1 20:54
 * @Author: 后端阿勇
 * @ClassDescription:
 */


public interface PayService {
    public int add(Pay pay);
    public int delete(Integer id);
    public int update(Pay pay);
    public List<Pay> getAll();
    public  Pay getById(Integer id);
}
