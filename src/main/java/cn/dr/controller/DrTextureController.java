package cn.dr.controller;


import cn.dr.service.IDrTextureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author zcw
 * @since 2019-06-26
 */
@RestController
@RequestMapping("/dr-texture")
public class DrTextureController {

    @Autowired
    private IDrTextureService drTextureService;

    @RequestMapping("/list")
    public Object list() {
        return drTextureService.getTextureList();
    }

}
