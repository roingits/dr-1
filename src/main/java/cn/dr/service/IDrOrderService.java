package cn.dr.service;

import cn.dr.entity.DrOrder;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
public interface IDrOrderService extends IService<DrOrder> {

    List<DrOrder> findDrOrderByUserId(Integer id,Integer statusCode);
}
