package cn.sf.userapi.service;

import cn.sf.common.constant.Tips;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * 使用sentinel进行服务降级、熔断
 * （或者hystrix）
 */
@Slf4j
@Component
public class UserServiceFallbackFactory implements FallbackFactory<UserService> {

    @Override
    public UserService create(Throwable cause) {
        return new UserService() {
            @Override
            public String getById(String userId) {
                return Tips.SERVICE_NOT_AVAILABLE;
            }
        };
    }
}
