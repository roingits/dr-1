package cn.dr.controller;


import cn.dr.entity.DrComment;
import cn.dr.service.IDrCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@RestController
@RequestMapping("/dr-comment")
public class DrCommentController {

    @Autowired
    private IDrCommentService commentService;

    @RequestMapping("/count")
    public Object count(Integer pid){
        return commentService.getCommentCountByPid(pid);
    }

    @RequestMapping("/comments")
    public Object comments(Integer pid, Integer pageNo, ModelAndView mav){
        if(pageNo == null || pageNo == 0) pageNo = 1;//初始化页码信息
        List<DrComment> comments = commentService.getCommentsByPid(pid, pageNo, 5);
        int commentCount = commentService.getCommentCountByPid(pid);
        mav.addObject("commentCount",commentCount);
        mav.addObject("comments",comments);
        mav.setViewName("detail::wrap13");
        return mav;
    }

}
