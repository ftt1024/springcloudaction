package cn.sf.user.service;

import cn.sf.user.entity.UserBO;
import cn.sf.user.entity.UserVO;
import cn.sf.user.mapper.UserMapper;
import cn.sf.user.model.User;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.google.common.collect.Lists;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sf
 * @since 2021-05-30
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public UserVO getByCode(String code) {
        // todo 查询缓存
        // 如果没有缓存则查db
        // User user =userMapper.selectById(code);
        UserBO userBO = new UserBO();
        userBO.setCode(code);
        List<UserVO> list = this.getListByCondition(userBO);
        if (list == null || list.size() == 0) {
            return null;
        }

        // 保存到缓存
        return list.get(0);
    }

    @Override
    public List<UserVO> getListByCondition(UserBO userBO) {
        User user = new User();
        BeanUtils.copyProperties(userBO, user);
        List<User> list = userMapper.selectByFullCondition(user);
        if (list == null || list.size() == 0) {
            return null;
        }
        List userList =
//                list.stream().map(u -> ObjectUtil.
//                fromJson(ObjectUtil.toJson(u), UserVO.class)).
//                collect(Collectors.toList());
                Lists.transform(list, (u -> {
                    UserVO userVO = new UserVO();
                    BeanUtils.copyProperties(u, userVO);
                    return userVO;
                }));
        return userList;
    }
}
