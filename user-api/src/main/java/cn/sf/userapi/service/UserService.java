package cn.sf.userapi.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * user api
 * feign继承方式
 */
@FeignClient(value = "user-service", fallbackFactory = UserServiceFallbackFactory.class)
public interface UserService {

    @GetMapping("/api/user/id/{userId}")
    String getById(@PathVariable String userId);

}
