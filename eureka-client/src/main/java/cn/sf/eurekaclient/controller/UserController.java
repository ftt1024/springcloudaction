package cn.sf.eurekaclient.controller;

import cn.sf.userapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/feign/user")
public class UserController {

    @Autowired
    private UserService userService;

    @Cacheable(value = "uid_", key = "${userId}", condition = "#result != null")
    @GetMapping("/id/{userId}")
    public String getById(@PathVariable String userId) {
        log.info("userId is: {}", userId);
        return userService.getById(userId);
    }
}
