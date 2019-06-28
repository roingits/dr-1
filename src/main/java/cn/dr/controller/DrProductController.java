package cn.dr.controller;


import cn.dr.entity.DrProduct;
import cn.dr.service.IDrProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zcw
 * @since 2019-06-27
 */
@RestController
@RequestMapping("/dr-product")
public class DrProductController {

    @Autowired
    private IDrProductService drProductService;

    @RequestMapping("/list")
    public Object list(Integer drpListPrice, Integer drplistzct, Integer drpListCZ, String txtTitle) {
        System.out.println(drpListPrice + "   " + drplistzct + "   " + drpListCZ + "    " + txtTitle);
        QueryWrapper<DrProduct> qw = new QueryWrapper<>();
        switch (drpListPrice) {

            case -1:
                break;

            case 1:
                qw.lt("price", 5000);
                break;

            case 2:
                qw.between("price", 5000, 10000);
                break;

            case 3:
                qw.between("price",10001,20000);
                break;

            case 4:
                qw.gt("price",20000);
                break;
        }
        return drProductService.list(qw);
    }

}
