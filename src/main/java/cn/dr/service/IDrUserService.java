package cn.dr.service;

import cn.dr.entity.DrUser;
import com.baomidou.mybatisplus.extension.service.IService;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

import java.util.List;

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

    /**
     * 修改个人信息
     */
    public int perfect(List<Object> list);

    /**
     * 检查密码
     * @param pwd
     * @param id
     * @return
     */
    public int checkPwd(String pwd,Integer id);

    /**
     * 修改密码
     * @param pwd
     * @param id
     * @return
     */
    public int updatePwd(String pwd,Integer id);

}
