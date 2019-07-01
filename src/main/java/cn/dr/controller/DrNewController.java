package cn.dr.controller;


import cn.dr.entity.DrNew;
import cn.dr.entity.DrNewPicture;
import cn.dr.service.IDrNewPictureService;
import cn.dr.service.IDrNewService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zcw
 * @since 2019-06-27
 */
@RestController
@RequestMapping("/dr-new")
public class DrNewController {

    @Autowired
    private IDrNewService iDrNewService;

    @RequestMapping("/rightNew")
    public String rightNew() {
        List<DrNew> drNewList = iDrNewService.list();
//        drNewList.forEach(System.out::println);
        return JSONObject.toJSONString(drNewList);
    }



}
