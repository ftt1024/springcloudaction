package cn.sf.user.controller;


import cn.sf.common.constant.Tips;
import cn.sf.user.aop.ARC;
import cn.sf.user.aop.RCache;
import cn.sf.user.aop.RCacheEvict;
import cn.sf.user.aop.RCachePut;
import cn.sf.user.constant.RedisKeyConstant;
import cn.sf.user.entity.UserBO;
import cn.sf.user.model.User;
import cn.sf.user.service.IUserService;
import cn.sf.user.util.ObjectUtil;
import cn.sf.userapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
@RequestMapping("/api/user")
@CacheConfig(cacheNames = "u_")
public class UserController implements UserService {

    @Autowired
    private IUserService iUserService;

    // @Cacheable(value = RedisKeyConstant.USER_ID, key = "#id", unless = "#result == null")
    @RCache(key = RedisKeyConstant.USER_ID, value = "#id", expire = 86400000)
    @GetMapping("/id/{id}")
    @Override
    public String getById(@PathVariable String id) {
        log.info("User id is :{}", id);
        User user = iUserService.getById(id);
        String result = null;
        if (user != null) {
            result = ObjectUtil.toJson(user);
        }
        return result;
    }

    @ARC(value = "#userBO.code", key = "ANTI-RC:", expire = 5, timeUnit = TimeUnit.SECONDS)
    // @RCachePut(key = RedisKeyConstant.USER_ID, value = "#userBO.code", expire = 86400000)
    @RCacheEvict(key = RedisKeyConstant.USER_ID, value = "#userBO.code")
    @PostMapping(value = "add", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String add(@RequestBody @Validated UserBO userBO) {
        User user = iUserService.getById(userBO.getCode());
        if (user != null) {
            log.info("用户已存在:{}", userBO.getCode());
            return Tips.SERVICE_FAIL;
        }
        user = new User();
        BeanUtils.copyProperties(userBO, user);
        boolean suc = iUserService.save(user);
        if (suc) {
            return "success";
        }
        return "fail";
    }

    @ARC(value = "#userBO.code", key = "ANTI-RC:", expire = 5, timeUnit = TimeUnit.SECONDS)
    // @RCachePut(key = RedisKeyConstant.USER_ID, value = "#userBO.code", expire = 86400000)
    @RCacheEvict(key = RedisKeyConstant.USER_ID, value = "#userBO.code")
    @PostMapping(value = "update", consumes = MediaType.APPLICATION_JSON_VALUE)
    public String update(@RequestBody @Validated UserBO userBO) {
        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        boolean updated = iUserService.updateById(user);
        if (!updated) {
            return "fail";
        }
        return "success";
    }

    @RCacheEvict(key = RedisKeyConstant.USER_ID, value = "#id")
    @DeleteMapping("/id/{id}")
    public String delete(@PathVariable String id) {
        boolean deleted = iUserService.removeById(id);
        if (!deleted) {
            return "fail";
        }
        return "success";
    }
}
