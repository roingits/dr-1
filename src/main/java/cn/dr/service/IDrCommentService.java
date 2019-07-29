package cn.dr.service;

import cn.dr.entity.DrComment;
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
public interface IDrCommentService extends IService<DrComment> {

    /**
     * 获取一条商品评价数量
     * @return
     */
    int getCommentCountByPid(Integer pid);

    /**
     * 分页获取商品评论
     * @param pid
     * @param pageNo
     * @param pageSize
     * @return
     */
    List<DrComment> getCommentsByPid(Integer pid, int pageNo, int pageSize);

}
