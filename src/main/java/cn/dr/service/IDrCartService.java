package cn.dr.service;

import cn.dr.entity.DrCart;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
public interface IDrCartService extends IService<DrCart> {

    /**
     * 获取用户购物车中的所有信息
     * @param uid
     * @return
     */
    List<DrCart> getCartsByUid(Integer uid);

    /**
     * 清空对应用户的购物车
     * @param uid
     */
    int delCartByUid(Integer uid);

    /**
     * 根据用户id获取购物车中的商品信息
     * @param uid
     * @return
     */
    List<Map<String,Object>> getCartProductByUid(Integer uid);

    /**
     * 根据购物车id删除对应购物车中的信息
     * @return
     */
    int delCartByCid(Integer... cid);

}
