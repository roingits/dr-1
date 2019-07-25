package cn.dr.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class MyPwd {


    public static String getPwd(String username,String pwd){

        System.out.println(username+"mima"+pwd+"MyPWd");
        //加密方式
        String hashAlgorithmName = "MD5";
        //盐值
        Object salt = ByteSource.Util.bytes(username);
        int hashIterations = 1024;
        Object result = new SimpleHash(hashAlgorithmName, pwd, salt, hashIterations);
        System.out.println(result.toString());
        return result.toString();
    }
}
