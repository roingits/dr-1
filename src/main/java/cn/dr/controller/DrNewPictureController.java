package cn.dr.controller;


import cn.dr.entity.DrNewPicture;
import cn.dr.service.IDrNewPictureService;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
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
@RequestMapping("/dr-new-picture")
public class DrNewPictureController {

    @Autowired
    private IDrNewPictureService iDrNewPictureService;

    @RequestMapping("/rightNewPicture")
    public String rightNewPicture(@RequestParam("newId") Integer newId) {
        QueryWrapper queryWrapper = new QueryWrapper();
        Map<String , Integer> map = new HashMap<>();
        map.put("new_id",newId);
        queryWrapper.allEq(map);
        DrNewPicture drNewPicture = iDrNewPictureService.getOne(queryWrapper);
        return JSONObject.toJSONString(drNewPicture);
    }

}
