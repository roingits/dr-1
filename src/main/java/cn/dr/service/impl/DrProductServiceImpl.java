package cn.dr.service.impl;

import cn.dr.entity.DrProduct;
import cn.dr.mapper.DrProductMapper;
import cn.dr.service.IDrProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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
    @Resource
    private DrProductMapper productMapper;

    @Override
    public List<DrProduct> findPageProduct(QueryWrapper<DrProduct> qw, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum,pageSize);//设置分页条件
        List<DrProduct> products = productMapper.selectList(qw);
        System.out.println("ssssssssssssssssssssssssssssssssssssssssssssssssssssssssssss  " + products.size());
        return products;
    }

    @Override
    public DrProduct findProductById(Integer id) {
        return productMapper.selectById(id);
    }
}
