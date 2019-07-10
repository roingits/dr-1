package cn.dr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 专门负责跳页的Controller
 */
@Controller
public class DrApplicationController {

    @RequestMapping("/index.html")
    public String index(){
        return "index";
    }
    
    @RequestMapping("/lists.html")
    public String list(){
        return "lists";
    }
    
    @RequestMapping("/brand.html")
    public String brand(){
        return "brand";
    }
    
    @RequestMapping("/detail.html")
    public String detail(){
        return "detail";
    }

    /**
     * 主页面跳转到登录页面
     */
    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }

    /**
     * 主页跳转注册页面
     * @return reg.html
     */
    @RequestMapping("/reg.html")
    public String register(){
        return "reg";
    }

    /**
     * 跳转到个人信息页面
     * @return
     */
    @RequestMapping("/member_index.html")
    public String info(){
        return "member_index";
    }

    @RequestMapping("/test")
    public String test(){
        return "test";
    }
}
