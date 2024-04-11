package com.atguigu.cloud;

import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.cloud.gateway.handler.predicate.AbstractRoutePredicateFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.server.ServerWebExchange;

import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

/**
 * ProjectName: Cloud2024
 *
 * @Created: 2024/4/7 15:58
 * @Author: 后端阿勇
 * @ClassDescription:
 */

@Component
public class MyRoutePredicateFactory extends AbstractRoutePredicateFactory<MyRoutePredicateFactory.Config> {
    @Validated
    public static class Config{
        @NotEmpty @Setter @Getter
        private String userType;
    }
    public MyRoutePredicateFactory(){
        super( MyRoutePredicateFactory.Config.class);
    }
    @Override
    public Predicate<ServerWebExchange> apply(MyRoutePredicateFactory.Config config) {
        return new Predicate<ServerWebExchange>() {
            @Override
            public boolean test(ServerWebExchange serverWebExchange) {
                String userType = serverWebExchange.getRequest().getQueryParams().getFirst("userType");
                if (userType==null) {
                    return false;
                }
                if (userType.equalsIgnoreCase(config.getUserType())) {
                    return true;
                }
                return false;
            }
        };
    }

/*    @Override
    public List<String> shortcutFieldOrder() {
        return Collections.singletonList("userType");
    }*/
}
