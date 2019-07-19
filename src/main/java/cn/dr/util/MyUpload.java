package cn.dr.util;

import cn.dr.entity.DrUser;
import org.apache.commons.io.FilenameUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Random;

@RestController
public class MyUpload {

    @RequestMapping("/jj")
    public String jj(){

        return "123";
    }

    //logback日志对象
    private final static Logger logger = LoggerFactory.getLogger(MyUpload.class);

    /**
     * 上传文件，把文件完整路径直接存储在登录用户中
     */
    @PostMapping("/upload")
    public String uploadName(HttpSession session,@RequestParam("myfile") MultipartFile attach){
        String idPath=null;   //作为数据库存放绝对路径
        String fileName=null;  //作为页面展示为相对路径
        //判断文件是否为空
        if(!attach.isEmpty()){
            //获取跟目录
            File path = null;
            try {
                path = new File(ResourceUtils.getURL("classpath:").getPath());
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            logger.info("path:"+path.getAbsolutePath());

            //如果上传目录为/static/images/upload/，则可以如下获取：
            File upload = new File(path.getAbsolutePath(),"static"+File.separator+"images"+File.separator+"upload");
            if(!upload.exists()) upload.mkdirs();
            logger.info("upload url:"+upload.getAbsolutePath());
            //在开发测试模式时，得到的地址为：{项目跟目录}/target/static/images/upload/
            //在打包成jar正式发布时，得到的地址为：{发布jar包目录}/static/images/upload/
            String oldFileName=attach.getOriginalFilename();  //原文件名
            logger.info("原文件名字:"+oldFileName);
            String prefix=FilenameUtils.getExtension(oldFileName);                      //获得文件的后缀格式
            logger.info("prefix"+prefix);
            int filesize=500000;               //上传图片大小
            logger.info("上传大小"+filesize);
            //如果上传大小大于500kb,上传失败
            if(attach.getSize()>filesize){
                return "图片大小超过500kb";

            }else if(prefix.equalsIgnoreCase("jpg")
                    ||prefix.equalsIgnoreCase("png")
                    ||prefix.equalsIgnoreCase("jpeg")
                    ||prefix.equalsIgnoreCase("pneg")){   //上传图片格式不正确
                fileName=System.currentTimeMillis()+new Random().nextInt(10000)+".jpg"; //重新命名图片
                logger.info("新文件名字"+upload+File.separator+fileName);
                File file=new File(upload,fileName);
                if(!file.exists()){
                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                //保存图片
                try {
                    attach.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                    return "上传失败";
                }
                idPath=upload+File.separator+fileName;  //完整图片路径

            }else{
                return "上传图片格式不正确";
            }

        }

        //把信息存储到登录用户信息中
        ((DrUser) session.getAttribute("user")).setUserHeadImg(fileName);
        logger.info(fileName+"页面相对路径");
        return fileName;
    }
}
