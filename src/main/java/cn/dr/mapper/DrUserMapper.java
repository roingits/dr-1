package cn.dr.mapper;

import cn.dr.entity.DrUser;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@Mapper
public interface DrUserMapper extends BaseMapper<DrUser> {

    /**
     * 通过邮箱进行注册
     * @param drUser
     * @return
     */
    @Insert({"INSERT `dr_user`(`email`,`password`,username,role) VALUES(#{email},#{password},#{email},#{role})"})
    public int addDrUser(DrUser drUser);

    /**
     * 验证邮箱没有注册过
     */
    @Select("SELECT email FROM `dr_user` WHERE email=#{email}")
    public DrUser findByEmail(@Param("email") String email);

    /**
     * 通过用户名查找
     */
    @Select("SELECT * FROM `dr_user` WHERE email=#{username}")
    public DrUser findByUsername(@Param("username") String username);

    /**
     * 完善个人资料
     */
    @Update("UPDATE `dr_user` SET`email`=#{email},`username`=#{username},sex=#{sex},`question`=#{question},`answer`=#{answer},`user_head_img`=#{userHeadImg} WHERE `id`= #{id}")
    public int perfect(DrUser drUser);

}
