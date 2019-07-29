package cn.dr.mapper;

import cn.dr.entity.DrShipping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
public interface DrShippingMapper extends BaseMapper<DrShipping> {

    @Insert("INSERT INTO `dr_shipping`(`user_id`,`receiver_phone`,`receiver_mobile`,`receiver_province`,`receiver_city`,`receiver_district`,`receicer_address`,`receiver_zip`) VALUES(#{userId},#{receiverPhone},#{receiverMobile},#{receiverProvince},#{receiverCity},#{receiverDistrict},#{receicerAddress},#{receiverZip})")
    int addAddress(DrShipping drShipping);

    /**
     * 查询某个用户的所有地址
     */
    @Select("SELECT * FROM `dr_shipping` WHERE `user_id`=#{userId} ORDER BY `create_time` DESC ")
    List<DrShipping> findAllDrShippingByUserId(Integer userId);

    /**
     * 添加多一个真实姓名
     *
     * @param drShipping
     * @return
     */
    @Insert("INSERT INTO `dr_shipping`(`user_id`,`receiver_name`,`receiver_phone`,`receiver_mobile`,`receiver_province`,`receiver_city`,`receiver_district`,`receicer_address`,`receiver_zip`) VALUES(#{userId},#{receiverName},#{receiverPhone},#{receiverMobile},#{receiverProvince},#{receiverCity},#{receiverDistrict},#{receicerAddress},#{receiverZip})")
    int addAddressAll(DrShipping drShipping);

    /**
     * 更新数据
     */
    @Update("UPDATE `dr_shipping` SET `receiver_name`=#{receiverName},`receiver_phone`=#{receiverPhone},`receiver_mobile`=#{receiverMobile},`receiver_province`=#{receiverProvince},`receiver_city`=#{receiverCity},`receiver_district`=#{receiverDistrict},`receicer_address`=#{receicerAddress},`receiver_zip`=#{receiverZip} WHERE id=#{id}")
    int updateAddress(DrShipping drShipping);
}

