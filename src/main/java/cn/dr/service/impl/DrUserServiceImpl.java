package cn.dr.service.impl;

import cn.dr.entity.DrUser;
import cn.dr.mapper.DrUserMapper;
import cn.dr.service.IDrUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@Service
public class DrUserServiceImpl extends ServiceImpl<DrUserMapper, DrUser> implements IDrUserService {
    @Resource
    DrUserMapper drUserMapper;

    @Override
    public int addDrUser(DrUser drUser) {
         int num;

        //验证邮箱唯一性,-1添加异常，0邮箱已被使用
        if(drUserMapper.findByEmail(drUser.getEmail())==null){
            try {
                return drUserMapper.addDrUser(drUser);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    @Override
    public boolean findByEmail(String email) {
        if(drUserMapper.findByEmail(email)!=null){
           return false;
        }
        return true;
    }
}
