package cn.dr.controller;


import cn.dr.entity.DrCart;
import cn.dr.entity.DrUser;
import cn.dr.service.IDrCartService;
import cn.dr.util.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
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
@RequestMapping("/dr-cart")
public class DrCartController {



    @Autowired
    private IDrCartService drCartService;

    @RequestMapping("/addToCart")
    public Object addToCart(Integer pid){
        DrUser user = UserInfo.getCurrentUser();
        if(user == null){
            return "noUser";
        }
        DrCart drCart = new DrCart();
        drCart.setUserId(user.getId());
        drCart.setProductId(pid);
        return drCartService.addToCart(drCart);
    }

    /**
     * 清空用户购物车
     * @return
     */
    @RequestMapping("/clearCart")
    public Object clearCart() {

        return drCartService.delCartByUid(UserInfo.getCurrentUser().getId());
    }

    /**
     * 删除一条购物车信息
     *
     * @param cid
     * @return
     */
    @RequestMapping("/delProduct")
    public Object delProduct(Integer... cid) {
        return drCartService.delCartByCid(cid);
    }

    /**
     * 获取购物车中的所有商品信息
     *
     * @param mav
     * @return
     */
    @RequestMapping("/products")
    public Object products(ModelAndView mav) {

        List<Map<String, Object>> products = drCartService.getCartProductByUid(UserInfo.getCurrentUser().getId());

        mav.addObject("products", products);
        mav.setViewName("cart::products");
        return mav;
    }

}
