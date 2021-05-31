package cn.sf.user;

import cn.sf.user.entity.UserBO;
import cn.sf.user.entity.UserVO;
import cn.sf.user.model.User;
import cn.sf.user.service.IUserService;
import cn.sf.user.util.ObjectUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
class UserApplicationTests {
    @Autowired
    private IUserService userService;

    @Test
    void contextLoads() {
        UserVO user;
        user = userService.getByCode("C00001");
        log.info("User:{}", user);
    }

    @Test
    public void testSelectByCondition() {
        UserBO userBO = new UserBO();
        userBO.setName("我");
        List<UserVO> list = userService.getListByCondition(userBO);
        log.info("User list:{}", list);
    }

    @Test
    public void testAddUser() {
        User user = new User();
        user.setCode("C00002");
        user.setName("2号员工");
        user.setSex("0");
        userService.save(user);
    }

    @Test
    public void testSelectAll() {
        List<User> list = userService.list();
        log.info("User list: {}", ObjectUtil.toJson(list));
    }
}
