package cn.dr.mapper;

import cn.dr.entity.DrOrder;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  订单 接口
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
public interface DrOrderMapper extends BaseMapper<DrOrder> {

    /**
     * 通过userid查询所有订单，状态不分
     * @param id
     * @return
     */
    @Select("SELECT * FROM `dr_order` WHERE user_id=#{id}")
    List<DrOrder> findDrOrderByUserId(Integer id);
}
