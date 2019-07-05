package cn.dr;

import cn.dr.service.IDrNewPictureService;
import cn.dr.entity.DrCategory;
import cn.dr.entity.DrProduct;
import cn.dr.entity.DrTexture;
import cn.dr.entity.DrUser;
import cn.dr.service.IDrCategoryService;
import cn.dr.service.IDrProductService;
import cn.dr.service.IDrTextureService;
import cn.dr.service.impl.DrUserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrApplicationTests {

    @Autowired
    private IDrNewPictureService iDrNewPictureService;

    @Resource
    private IDrCategoryService drCategoryService;

    @Resource
    private IDrTextureService drTextureService;

    @Resource
    private IDrProductService drProductService;

    @Resource
    private DrUserServiceImpl drUserService;

    @Test
    public void contextLoads() {
        Random r = new Random();
        String[] type = {"经典款","典雅","简奢款","纯爱","花影"};
        List<DrProduct> products = new ArrayList<>();
        for (int i = 100032; i < 100037; i++) {
            DrCategory category = drCategoryService.getById(i);//商品系列
            for (int j = 26; j < 30; j++) {
                DrTexture texture = drTextureService.getById(j);
                DrProduct drProduct = new DrProduct();//要添加的商品
                drProduct.setCategoryId(i);
                drProduct.setTextureId(j);
                drProduct.setQuality(r.nextInt(190) + 10);//商品质量
                drProduct.setStock(9999);//库存
                drProduct.setName(category.getName() + " " + texture.getTextureName() + " " + type[r.nextInt(5)] + "" + drProduct.getQuality() + "分 ");
            }
        }
    }

    @Test
    public void test1(){
        DrUser  drUser=drUserService.findByUsername("2420398728@qq.com");

        System.out.println(drUser.getUsername());
        System.out.println(drUser.getPassword());
        System.out.println(drUser.getEmail());

            System.out.println((char)ThreadLocalRandom.current().nextInt(65, 90));
        }
}

