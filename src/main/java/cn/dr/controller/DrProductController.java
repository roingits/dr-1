package cn.dr.controller;


import cn.dr.entity.DrProduct;
import cn.dr.entity.DrUser;
import cn.dr.service.IDrProductService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@RestController
@Slf4j
@RequestMapping("/dr-product")
public class DrProductController {

    @Autowired
    private IDrProductService drProductService;

    /**
     * 根据条件查询商品
     * @param drpListPrice
     * @param drplistzct
     * @param drpListCZ
     * @param txtTitle 商品关键字
     * @param lbCurrent 当前页码
     * @param cid 商品类别id
     * @param mav
     * @return
     */
    @RequestMapping("/list")
    public Object list(Integer drpListPrice, Integer drplistzct, Integer drpListCZ, String txtTitle, Integer lbCurrent,
                       Integer cid, String sortBy, ModelAndView mav) {
        log.info(drpListPrice + "   " + drplistzct + "   " + drpListCZ + "    " + txtTitle + "     "
                + lbCurrent + "     " + cid + "      " + sortBy);
        lbCurrent = (lbCurrent == null || lbCurrent == 0) ? 1 : lbCurrent;//如果没有页码信息将页码初始化为1
        //声明条件构造器
        QueryWrapper<DrProduct> qw = new QueryWrapper<>();
        //根据价格构造条件
        if (drpListPrice != null)
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
                    qw.between("price", 10001, 20000);
                    break;

                case 4:
                    qw.gt("price", 20000);
                    break;
            }

        //根据质量筛选条件
        if (drplistzct != null)
            switch (drplistzct) {
                case -1:
                    break;

                case 1:
                    qw.lt("quality", 10);
                    break;

                case 2:
                    qw.between("quality", 10, 30);
                    break;

                case 3:
                    qw.between("quality", 31, 50);
                    break;

                case 4:
                    qw.between("quality", 51, 100);
                    break;

                case 5:
                    qw.gt("quality", 101);
                    break;

                default:
                    break;
            }

        //根据材质筛选商品
        if (drpListCZ != null)
            switch (drpListCZ) {
                case -1:
                    break;

                default:
                    qw.eq("texture_id", drpListCZ);
            }

        //根据标题模糊查询
        if (txtTitle != null && !txtTitle.trim().equals("")) {
            qw.like("name", txtTitle);
        }

        //根据商品系列筛选商品
        if(cid != null && cid != 0)
            qw.eq("category_id",cid);

        if(sortBy != null && !sortBy.equals(""))
            qw.orderByAsc("price");

        //分页查询商品信息
        List<DrProduct> products = drProductService.findPageProduct(qw,lbCurrent,12);
        //获取符合条件的商品数量
        int count = drProductService.count(qw);
        mav.addObject("count", count);//设置符合条件的商品数量
        mav.addObject("products",products);//查询出来的所有商品
        int lbTot = (int) Math.ceil((count + 0.0) / 12);//计算总页数
        mav.addObject("lbTot",lbTot);//设置符合条件的商品页数
        mav.addObject("lbCurrent",lbCurrent);//设置当前页数
        mav.addObject("cid",cid);
        mav.addObject("sort_by",sortBy);//排序方式
        log.info("根据条件筛选出符合条件的商品:" + products.size() + "件");

        mav.setViewName("lists::products");//第一个为要跳转的视图名,第二个为要刷新的模块名
        return mav;//返回填充数据的模块
    }
}
