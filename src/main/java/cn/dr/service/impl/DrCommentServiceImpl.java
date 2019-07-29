package cn.dr.service.impl;

import cn.dr.entity.DrComment;
import cn.dr.mapper.DrCommentMapper;
import cn.dr.service.IDrCommentService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
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
public class DrCommentServiceImpl extends ServiceImpl<DrCommentMapper, DrComment> implements IDrCommentService {

    @Resource
    private DrCommentMapper commentMapper;

    @Override
    public int getCommentCountByPid(Integer pid) {
        QueryWrapper<DrComment> qw = new QueryWrapper<>();
        qw.eq("product_id",pid);
        return commentMapper.selectCount(qw);
    }

    @Override
    public List<DrComment> getCommentsByPid(Integer pid, int pageNo, int pageSize) {
        PageHelper.startPage(pageNo,pageSize);
        QueryWrapper<DrComment> qw = new QueryWrapper<>();
        qw.eq("product_id",pid);
        return commentMapper.selectList(qw);
    }
}
