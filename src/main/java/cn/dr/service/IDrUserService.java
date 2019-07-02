package cn.dr.service;

import cn.dr.entity.DrUser;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
public interface IDrUserService extends IService<DrUser> {
    /**
     * 邮箱注册，邮箱不能重复
     * @param drUser
     * @return
     */
    public int addDrUser(DrUser drUser);

    /**
     * 验证邮箱没有注册过
     */
    public DrUser findByEmail(String email);

    /**
     * 查找用户
     */
    public DrUser findByUsername(String username);


}
