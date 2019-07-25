package cn.dr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * 专门负责跳页的Controller
 */
@Controller
public class DrApplicationController {

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

    @RequestMapping("/lists.html")
    public String list() {
        return "lists";
    }

    @RequestMapping("/brand.html")
    public String brand() {
        return "brand";
    }

    @RequestMapping("/detail.html")
    public String detail() {
        return "detail";
    }

    /**
     * 主页面跳转到登录页面
     */
    @RequestMapping("/login.html")
    public String login() {
        return "login";
    }

    /**
     * 主页跳转注册页面
     *
     * @return reg.html
     */
    @RequestMapping("/reg.html")
    public String register() {
        return "reg";
    }

    /**
     * 跳转到个人信息页面
     *
     * @return
     */
    @RequestMapping("/member_index.html")
    public String info() {
        return "member_index";
    }

    /**
     * 个人信息到完善信息
     *
     * @return
     */
    @RequestMapping("/member_info.html")
    public String perfect() {
        return "member_info";
    }

    @RequestMapping("/test")
    public String test() {
        return "test";
    }

    /**
     * 跳转修改密码页面
     *
     * @return
     */
    @RequestMapping("/member_pwd.html")
    public String member_pwd() {
        return "member_pwd";
    }

    /**
     * 个人信息跳转到购物车
     *
     * @return
     */
    @RequestMapping("/cart.html")
    public String cart() {
        return "cart";
    }

    /**
     * 我的收藏
     * @return
     */
    @RequestMapping("/member_collect.html")
    public String member_collect(){return  "member_collect";}

    /**
     * 收货地址
     * @return
     */
    @RequestMapping("/member_addr.html")
    public String member_addr(){return "member_addr";}

}
