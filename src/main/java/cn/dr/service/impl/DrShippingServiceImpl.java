package cn.dr.service.impl;

import cn.dr.entity.DrShipping;
import cn.dr.mapper.DrShippingMapper;
import cn.dr.service.IDrShippingService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@Service
public class DrShippingServiceImpl extends ServiceImpl<DrShippingMapper, DrShipping> implements IDrShippingService {


    @Resource
    DrShippingMapper drShippingMapper;

    @Override
    public List<DrShipping> findAllDrShippingByUserId(Integer userId) {
        return drShippingMapper.findAllDrShippingByUserId(userId);
    }
}
