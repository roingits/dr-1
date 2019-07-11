package cn.dr.controller;


import cn.dr.entity.DrUser;
import cn.dr.service.impl.DrUserServiceImpl;
import cn.dr.util.MailUtil;
import cn.dr.util.ResultInfo;
import com.baomidou.mybatisplus.core.conditions.AbstractWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@RestController
@RequestMapping("/dr-user")
public class DrUserController {
    //日志
    private static final Logger logger = LoggerFactory.getLogger(DrUserController.class);

    @Autowired
    DrUserServiceImpl drUserService;

    /**
     * 邮箱验证
     */
    @GetMapping("/checkemail")
    public ResultInfo checkEmail(String email) {

        logger.info("进入邮箱验证功能");
        if (drUserService.findByEmail(email) == null) {
            return new ResultInfo(null, 0, "邮箱可以使用");
        }
        return new ResultInfo(null, 0, "邮箱已被使用");
    }

    /**
     * 发送注册邮箱验证码
     *
     * @param email
     * @return
     */
    @GetMapping("/sendCode")
    public ResultInfo sendCode(String email, HttpSession session) {
        //生成随机验证码
        String num = String.valueOf(Math.round(Math.random() * 999));

        try {
            MailUtil.send_mail(email, num);
            logger.info("发送成功");
            //因为在注册的时候还需要验证码匹配
            session.setAttribute("code", num);
            return new ResultInfo(null, 1, "发送成功");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        return new ResultInfo(null, 0, "发送失败");
    }

    ;


    /**
     * 进行注册
     *
     * @param drUser
     * @param session
     * @return
     */
    @PostMapping("/register")
    public ResultInfo register(DrUser drUser, HttpSession session) {

        logger.info("进入注册功能" + drUser);
        logger.info(session.getAttribute("code") + "");


        //验证码匹配
        if (!drUser.getEmail_code().equals(session.getAttribute("code"))) {

            return new ResultInfo(null, -2, "验证码错误");
        }

        int num = drUserService.addDrUser(drUser);
        //返回注册情况
        if (num > 0) {
            return new ResultInfo(null, 1, "注册成功");

        } else if (num == 0) {
            return new ResultInfo(null, -1, "邮箱已被使用");
        }
        return new ResultInfo(null, 0, "注册失败");
    }

    /**
     * 进行登录
     */
    @PostMapping("/login")
    public ResultInfo login(DrUser drUser, boolean rememberMe, HttpSession session) {
        //获得现在的主体
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(drUser.getUsername(), drUser.getPassword(), rememberMe);
        logger.info("记住我的属性" + rememberMe);
        logger.info(subject.getPrincipal() + "       " + drUser);
        logger.info(session.getAttribute("user") + "");
        try {
            subject.login(token);
            session.setAttribute("user", drUser);
        } catch (UnknownAccountException e) {

            return new ResultInfo(null, 0, "账号错误");

        } catch (IncorrectCredentialsException ice) {
            return new ResultInfo(null, -1, "密码错误");
        }
        return new ResultInfo(null, 1, "登录成功");
    }

    /**
     * 注销用户
     *
     * @return
     */
    @GetMapping("/loginout")
    public ResultInfo loginout() {
        logger.info("进入注销操作");
        Subject subject = SecurityUtils.getSubject();
        subject.logout();  //进行注销操作
        return new ResultInfo(null, 1, "注销成功");
    }


    @RequestMapping("/userOnlyCheck")
    public String userOnlyCheck(@RequestParam("textName2")String textName2){
        DrUser drUser = drUserService.findByUsername(textName2);
        if(drUser != null){
            return "true";
        }else{
            return "false";
        }
    }
}