package cn.dr.service.impl;

import cn.dr.entity.DrProduct;
import cn.dr.mapper.DrProductMapper;
import cn.dr.service.IDrProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@Service
public class DrProductServiceImpl extends ServiceImpl<DrProductMapper, DrProduct> implements IDrProductService {

}
