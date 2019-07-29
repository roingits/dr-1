package cn.dr.controller;


import cn.dr.entity.DrOrder;
import cn.dr.entity.DrShipping;
import cn.dr.entity.DrUser;
import cn.dr.service.IDrOrderService;
import cn.dr.service.IDrShippingService;
import cn.dr.service.IDrUserService;
import cn.dr.util.MailUtil;
import cn.dr.util.MyPwd;
import cn.dr.util.ResultInfo;
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
import java.util.ArrayList;
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
    IDrUserService drUserService;

    @Autowired
    IDrOrderService iDrOrderService;

    @Autowired
    IDrShippingService iDrShippingService;

    public static String sessionId;  //sessionid

    public static Map s = new HashMap();

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
    @GetMapping("/login")
    public ResultInfo login(DrUser drUser, boolean rememberMe, HttpSession session) {
        System.out.println("第一步");
        //获得现在的主体
        Subject subject = SecurityUtils.getSubject();
        if (!subject.isAuthenticated()) {
            UsernamePasswordToken token = new UsernamePasswordToken(drUser.getUsername(), drUser.getPassword(), rememberMe);
            logger.info("记住我的属性" + rememberMe);
            try {
                subject.login(token);
                DrUser drUser1 = drUserService.findByUsername(drUser.getUsername());
                List<DrOrder> list = iDrOrderService.findDrOrderByUserId(drUser1.getId(), 0);  //处理中
                List<DrOrder> list2 = iDrOrderService.findDrOrderByUserId(drUser1.getId(), 2); //评价
                session.setAttribute("user", drUser1);
                session.setAttribute("list", list);
                session.setAttribute("list2", list2);
                sessionId = session.getId();
                s.put(sessionId, session);

                System.out.println(session.getId() + "session1");
            } catch (UnknownAccountException e) {

                return new ResultInfo(null, 0, "账号错误");

            } catch (IncorrectCredentialsException ice) {
                return new ResultInfo(null, -1, "密码错误");
            }

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
        subject.logout();

        HttpSession session = (HttpSession) (s.get(sessionId));
        if (session != null) {
            session.invalidate();
        }


        return new ResultInfo(null, 1, "注销成功");
    }

    @PostMapping("/perfectInfo")
    public ResultInfo perfectInfo(@ModelAttribute("drUser") DrUser drUser, @ModelAttribute("drShipping") DrShipping drShipping, HttpSession session) {

        //因为用户id存储在session中，并没有在隐藏域中，直接在session中取出
        Integer id = ((DrUser) (session.getAttribute("user"))).getId();
        logger.info("会话中存储的id" + id + ",name:" + ((DrUser) (session.getAttribute("user"))).getUsername());
        logger.info(drUser.getUserHeadImg() + "图片路径");
        drUser.setId(id);
        drUser.setUserHeadImg(((DrUser) session.getAttribute("user")).getUserHeadImg());
        drShipping.setUserId(id);
        /**
         * 将前台的表单数据存储在list中
         */
        List<Object> list = new ArrayList<Object>();
        list.add(drUser);
        list.add(drShipping);
        int num = drUserService.perfect(list);
        return new ResultInfo(null, num, null);
    }


    /**
     * 检查用户唯一性
     *
     * @param textName2
     * @return
     */
    @RequestMapping("/userOnlyCheck")
    public String userOnlyCheck(@RequestParam("textName2") String textName2) {
        DrUser drUser = drUserService.findByUsername(textName2);
        if (drUser != null) {
            return "true";
        } else {
            return "false";
        }
    }


    @PostMapping("/updatePwd")
    public String updatePwd(String pwd) {

        HttpSession session = (HttpSession) s.get(sessionId);
        DrUser drUser = (DrUser) session.getAttribute("user");
        System.out.println(drUser.toString());
        Integer id = ((DrUser) session.getAttribute("user")).getId();
        System.out.println(drUser.getUsername());
        pwd = MyPwd.getPwd(drUser.getUsername(), pwd); //加密匹配
        //修改返回数据行
        if (drUserService.updatePwd(pwd, id) > 0) {

            ((DrUser) session.getAttribute("user")).setPassword(pwd);

            return "修改成功";
        }
        return "修改失败";
    }

    /**
     * 检查原密码正确性
     *
     * @param
     */
//    @PostMapping("/checkPwd")
//    public String checkPwd(String pwd) {
//        HttpSession session = (HttpSession) s.get(sessionId);  //根据sessionId获取session
//        Integer id = ((DrUser) session.getAttribute("user")).getId();
//        String pwd1=((DrUser) session.getAttribute("user")).getPassword();
//        //因为取出的密码是进行加密过得，所以加密匹对
//        pwd=MyPwd.getPwd(((DrUser) session.getAttribute("user")).getUsername(),pwd);
//        System.out.println("pwd"+pwd+"pwd1"+pwd1);
//        if (drUserService.checkPwd(pwd, id) > 0) {
//
//            return "原密码正确";
//        };
//
//        return "请输入正确的原密码";
//    }

    /**
     * 所有地址数据
     * @return
     */
    @GetMapping("/getAddress")
    public List getAddress(){
        HttpSession session = (HttpSession) s.get(sessionId);
        DrUser drUser = (DrUser) session.getAttribute("user");
        Integer id=drUser.getId();
        List<DrShipping> shipList=iDrShippingService.findAllDrShippingByUserId(id);
        return shipList;
    }


}