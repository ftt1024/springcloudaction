package cn.sf.user.mapper;

import cn.sf.user.model.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  UserMapper extends BaseMapper<User> {

    @Select("SELECT * FROM USER WHERE CODE = #{code} ")
    List<User> selectByCode(User user);

    List<User> selectByFullCondition(User user);
}
