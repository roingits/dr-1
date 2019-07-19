package cn.dr.mapper;

import cn.dr.entity.DrShipping;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;

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
}
