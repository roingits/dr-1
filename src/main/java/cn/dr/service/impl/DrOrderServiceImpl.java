package cn.dr.service.impl;

import cn.dr.entity.DrOrder;
import cn.dr.mapper.DrOrderMapper;
import cn.dr.service.IDrOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
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
public class DrOrderServiceImpl extends ServiceImpl<DrOrderMapper, DrOrder> implements IDrOrderService {

    @Resource
    DrOrderMapper drOrderMapper;

    @Override
    public List<DrOrder> findDrOrderByUserId(Integer id,Integer statusCode) {
        List<DrOrder> list=drOrderMapper.findDrOrderByUserId(id);  //查询出全部
        List<DrOrder> list2=new ArrayList<DrOrder>();  //用于返回相应状态码的订单集合

        for (int i=0;i<list.size();i++){

            if(((DrOrder)list.get(i)).getStatus()==statusCode){
                list2.add(list.get(i));
            }
        }
        return list2;
    }
}
