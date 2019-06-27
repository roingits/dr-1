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

    @RequestMapping("/login.html")
    public String login(){
        return "login";
    }
    
    @RequestMapping("/reg.html")
    public String reg(){
        return "reg";
    }
}
