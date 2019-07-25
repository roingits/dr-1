package cn.dr.mapper;

import cn.dr.entity.DrCart;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
public interface DrCartMapper extends BaseMapper<DrCart> {

    /**
     * 根据用户id获取购物车中的商品信息
     * @param uid
     * @return
     */
    List<Map<String,Object>> getCartProductByUid(@Param("uid") Integer uid);

}
