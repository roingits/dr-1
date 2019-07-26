package cn.dr.util;

import cn.dr.controller.DrUserController;
import cn.dr.entity.DrUser;

import javax.servlet.http.HttpSession;

public class UserInfo {

    //当前登录的用户id
    public static DrUser getCurrentUser() {
        HttpSession session = (HttpSession) (DrUserController.s.get(DrUserController.sessionId));
        DrUser user = (DrUser) session.getAttribute("user");
        return user;
    }
}
