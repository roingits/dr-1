package cn.dr.service;

import cn.dr.entity.DrProduct;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
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
public interface IDrProductService extends IService<DrProduct> {

    /**
     * 根据条件查询商品信息
     * @param qw
     * @param pageNum
     * @param pageSize
     * @return
     */
    List<DrProduct> findPageProduct(QueryWrapper<DrProduct> qw, Integer pageNum, Integer pageSize);
}
