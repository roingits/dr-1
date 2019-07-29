package cn.dr.util;

import cn.dr.controller.DrUserController;
import cn.dr.entity.DrUser;

import javax.servlet.http.HttpSession;

public class UserInfo {

    //当前登录的用户id
    public static DrUser getCurrentUser() {
        DrUser user = null;
        try {
            HttpSession session = (HttpSession) (DrUserController.s.get(DrUserController.sessionId));
            user = (DrUser) session.getAttribute("user");
        } catch (NullPointerException e) {
            user = null;
        }catch (Exception e1){
            e1.printStackTrace();
        }
        return user;
    }
}
