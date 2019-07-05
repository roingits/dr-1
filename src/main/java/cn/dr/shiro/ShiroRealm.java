package cn.dr.shiro;

import cn.dr.controller.DrUserController;
import cn.dr.entity.DrUser;
import cn.dr.mapper.DrUserMapper;
import cn.dr.service.impl.DrUserServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;

/**
 * 自定义ShiroRealm类
 */
public class ShiroRealm extends AuthorizingRealm {

    //日志
    private static final Logger logger = LoggerFactory.getLogger(ShiroRealm.class);
    //信息
    private SimpleAuthenticationInfo info = null;

    @Resource
    DrUserServiceImpl drUserService;

    public String getName() {
        return "mysqlRealm";
    }

    /**
     * 认证
     *
     * @param authenticationToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //强制转换，封装信息
        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String username = token.getUsername(); //获得用户名
        DrUser drUser = drUserService.findByUsername(username); //从数据库查找信息

        if (drUser != null) {
            logger.info(drUser.getUsername());
            logger.info(drUser.getPassword());

            // 如果查询到了，转换查询结果，返回给我们的调用
            Object principal = drUser.getUsername();
            Object credentials = drUser.getPassword();

            //获得盐值
            ByteSource salt = ByteSource.Util.bytes(username);
            //获得realmName
            String realmName = this.getName();

            logger.info("自定义realmName名字" + realmName);
            // 将账户名，密码，盐值，realmName实例化到SimpleAuthenticationInfo中交给Shiro来管理
            info = new SimpleAuthenticationInfo(principal, credentials, salt, realmName);

        } else if (drUser == null) {
            // 如果没有查询到，抛出一个异常
            return null;
        }


        return info;
    }

    /**
     * 授权
     *
     * @param principalCollection
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}
