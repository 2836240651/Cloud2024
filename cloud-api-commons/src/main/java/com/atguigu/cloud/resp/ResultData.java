package com.atguigu.cloud.resp;

import lombok.Data;
import lombok.experimental.Accessors;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/2 14:02
 * @Author: 后端阿勇
 * @ClassDescription:
 */
@Data
@Accessors(chain = true)
public class ResultData<T>{
private String code;
private String message;
private long timestamp;
private T data;
public ResultData(){
    this.timestamp=System.currentTimeMillis();
}
public static <T> ResultData<T> success(T data){
    ResultData resultData = new ResultData<>();
    resultData.setCode(ReturnCodeEnum.RC200.getCode());
    resultData.setMessage(ReturnCodeEnum.RC200.getMessage());
    resultData.setData(data);
    return resultData;
}
public static <T> ResultData<T> fail(String code,String message){
    ResultData resultData = new ResultData<>();
    resultData.setCode(code);
    resultData.setMessage(message);
    resultData.setData(null);
    return resultData;
}
}
