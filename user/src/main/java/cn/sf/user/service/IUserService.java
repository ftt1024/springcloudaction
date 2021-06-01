package cn.sf.user.service;

import cn.sf.user.entity.UserBO;
import cn.sf.user.entity.UserVO;
import cn.sf.user.model.User;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author sf
 * @since 2021-05-30
 */
public interface IUserService extends IService<User> {

    UserVO getByCode(String code);

    List<UserVO> getListByCondition(UserBO userBO);
}
