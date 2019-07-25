package cn.dr;

import cn.dr.service.IDrCartService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrCartTest {

    @Autowired
    private IDrCartService drCartService;

    @Test
    public void testGetCartProduct(){
        List<Map<String, Object>> products = drCartService.getCartProductByUid(23);
        for (Map<String, Object> product : products) {
            for (String s : product.keySet()) {
                System.out.print(s + " : " + product.get(s));
            }
            System.out.println();
        }
    }


    @Test
    public void testDelCart(){
        drCartService.delCartByUid(27);
    }
    
}
