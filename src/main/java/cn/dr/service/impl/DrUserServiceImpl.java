package cn.dr.service.impl;

import cn.dr.entity.DrUser;
import cn.dr.mapper.DrUserMapper;
import cn.dr.service.IDrUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@Service
public class DrUserServiceImpl extends ServiceImpl<DrUserMapper, DrUser> implements IDrUserService {

}
