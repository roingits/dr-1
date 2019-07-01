package cn.dr;

import cn.dr.entity.DrNewPicture;
import cn.dr.service.IDrNewPictureService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DrApplicationTests {

    @Autowired
    private IDrNewPictureService iDrNewPictureService;

    @Test
    public void contextLoads() {
        DrNewPicture drNewPicture = iDrNewPictureService.getById(32);
        System.out.println(drNewPicture);
    }

}
