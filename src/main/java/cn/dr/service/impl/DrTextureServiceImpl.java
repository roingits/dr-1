package cn.dr.service.impl;

import cn.dr.entity.DrTexture;
import cn.dr.mapper.DrTextureMapper;
import cn.dr.service.IDrTextureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author zcw
 * @since 2019-06-27
 */
@Service
public class DrTextureServiceImpl extends ServiceImpl<DrTextureMapper, DrTexture> implements IDrTextureService {

    @Resource
    private DrTextureMapper drTextureMapper;

    @Override
    public List<DrTexture> getTextureList() {
        return drTextureMapper.selectList(null);
    }
}
