package cn.dr.service;

import cn.dr.entity.DrTexture;
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
public interface IDrTextureService extends IService<DrTexture> {

    /**
     * 获取所有材质分类
     * @return
     */
    List<DrTexture> getTextureList();

    /**
     * 根据分类id获取分类信息
     * @param tid
     * @return
     */
    DrTexture getTexttureById(Integer tid);

}
