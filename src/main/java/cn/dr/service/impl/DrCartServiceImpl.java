package cn.dr.service.impl;

import cn.dr.entity.DrCart;
import cn.dr.mapper.DrCartMapper;
import cn.dr.service.IDrCartService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@Service
public class DrCartServiceImpl extends ServiceImpl<DrCartMapper, DrCart> implements IDrCartService {

    @Resource
    private DrCartMapper drCartMapper;

    @Override
    public List<DrCart> getCartsByUid(Integer uid) {
        QueryWrapper<DrCart> qw = new QueryWrapper<>();
        qw.eq("user_id",uid);
        return drCartMapper.selectList(qw);
    }

    @Override
    public int delCartByUid(Integer uid) {
        QueryWrapper<DrCart> qw = new QueryWrapper<>();
        qw.eq("user_id",uid);
        return drCartMapper.delete(qw);
    }

    @Override
    public List<Map<String,Object>> getCartProductByUid(Integer uid) {
        return drCartMapper.getCartProductByUid(uid);
    }

    @Override
    public int delCartByCid(Integer... cid) {
        QueryWrapper<DrCart> qw = new QueryWrapper<>();
        for (Integer id : cid) {
            qw.eq("id",id);
        }
        return drCartMapper.delete(qw);
    }

}
