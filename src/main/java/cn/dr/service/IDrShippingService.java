package cn.dr.service;

import cn.dr.entity.DrShipping;
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
public interface IDrShippingService extends IService<DrShipping> {

    List<DrShipping> findAllDrShippingByUserId(Integer userId);

}
