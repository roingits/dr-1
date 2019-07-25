package cn.dr.controller;


import cn.dr.service.IDrCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@RestController
@RequestMapping("/dr-cart")
public class DrCartController {

    @Autowired
    private IDrCartService drCartService;

    @RequestMapping("/clearCart")
    public Object clearCart(){

        return drCartService.delCartByUid(23);
    }

    /**
     * 删除一条购物车信息
     * @param cid
     * @return
     */
    @RequestMapping("/delProduct")
    public Object delProduct(Integer... cid){
        return drCartService.delCartByCid(cid);
    }
    
    /**
     * 获取购物车中的所有商品信息
     * @param mav
     * @return
     */
    @RequestMapping("/products")
    public Object products(ModelAndView mav){
        List<Map<String, Object>> products = drCartService.getCartProductByUid(23);

        mav.addObject("products",products);
        mav.setViewName("cart::products");
        return mav;
    }

}
