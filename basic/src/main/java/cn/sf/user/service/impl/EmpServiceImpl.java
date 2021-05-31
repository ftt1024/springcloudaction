package cn.sf.user.service.impl;

import cn.sf.user.entity.Emp;
import cn.sf.user.mapper.EmpMapper;
import cn.sf.user.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author sf
 * @since 2021-05-30
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

}
