package cn.dr.service.impl;

import cn.dr.controller.DrUserController;
import cn.dr.entity.DrUser;
import cn.dr.mapper.DrUserMapper;
import cn.dr.service.IDrUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    //日志
    private static final Logger logger = LoggerFactory.getLogger(DrUserController.class);
    @Resource
    DrUserMapper drUserMapper;

    @Override
    public int addDrUser(DrUser drUser) {
         int num;

        //验证邮箱唯一性,-1添加异常，0邮箱已被使用
        if(drUserMapper.findByEmail(drUser.getEmail())==null){
            try {

                //采用用户邮箱进行盐值
                ByteSource salt = ByteSource.Util.bytes(drUser.getEmail());
                logger.info("service层注册盐值"+salt);

                /*
                 * MD5加密：
                 * 使用SimpleHash类对原始密码进行加密。
                 * 第一个参数代表使用MD5方式加密
                 * 第二个参数为原始密码
                 * 第三个参数为盐值，即邮箱
                 * 第四个参数为加密次数
                 * 最后用toHex()方法将加密后的密码转成String
                 * */
                String newPs = new SimpleHash("MD5", drUser.getPassword(), salt, 1024).toHex();

                logger.info("加密后的密码"+newPs);

                drUser.setPassword(newPs);  //把加密后的密码切换到原本密码中

                return drUserMapper.addDrUser(drUser);
            } catch (Exception e) {
                e.printStackTrace();
                return -1;
            }
        }
        return 0;
    }

    @Override
    public DrUser findByEmail(String email) {
        DrUser drUser=drUserMapper.findByEmail(email);
        if(drUserMapper.findByEmail(email)!=null){
           return drUser;
        }
        return null;
    }

    @Override
    public DrUser findByUsername(String username) {

        return drUserMapper.findByUsername(username);
    }
}
