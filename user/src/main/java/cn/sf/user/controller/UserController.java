package cn.sf.user.controller;

//import cn.sf.user.entity.UserVO;

import cn.sf.user.model.User;
import cn.sf.user.service.IUserService;
import cn.sf.user.util.ObjectUtil;
import cn.sf.userapi.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserController implements UserService {

    @Autowired
    private IUserService iUserService;

    @GetMapping("/id/{id}")
    @Override
    public String getById(@PathVariable String id) {
        log.info("User id is :{}", id);
        User user = iUserService.getById(id);
        return user == null ? null : ObjectUtil.toJson(user);
    }
}
