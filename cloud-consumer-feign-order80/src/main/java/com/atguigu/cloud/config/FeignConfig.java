package com.atguigu.cloud.config;

import feign.Logger;
import feign.Retryer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.util.retry.Retry;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/4 14:35
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@Configuration
public class FeignConfig {
    @Bean
    public Retryer retryer(){
    return Retryer.NEVER_RETRY;
}
@Bean
    Logger.Level feignLoggerLevel(){
        return Logger.Level.FULL;
}
}
