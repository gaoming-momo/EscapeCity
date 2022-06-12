package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import java.io.*;

@RestController
public class FileUploadController {
    final Logger logger;

    public FileUploadController() {
        this.logger = LoggerFactory.getLogger(FileUploadController.class);
    }

    @RequestMapping(value = "/uploadFiles")
    public ApiResponse uploadFiles(@RequestParam("file") MultipartFile file, String openid, String userInfo) throws IOException {
        logger.error("收到上传请求 /uploadFiles");
        logger.error("openid：" + openid);
        logger.error("userInfo：" + userInfo);
        String uploadFileName = file.getOriginalFilename();
        logger.error("uploadFileName：" + uploadFileName);
        if (openid != null) {

            //上传路径保存设置
            //String path = request.getSession().getServletContext().getRealPath("/userpicture/");
            //写死了，和nginx配置文件里一致
            String path = "/usr/local/webserver/nginx/image";
            File realPath = new File(path);
            if (!realPath.exists()) {
                realPath.mkdir();
            }
            System.out.println("上传文件保存地址：" + realPath);
            InputStream is = file.getInputStream();//文件输入流
            OutputStream os = new FileOutputStream(new File(realPath, uploadFileName));//文件输出流
            //读取写出
            int len = 0;
            byte[] buffer = new byte[1024];
            while ((len = is.read(buffer)) != -1) {
                os.write(buffer, 0, len);
                os.flush();
            }
            os.close();
            is.close();
            return ApiResponse.ok();
        } else {
            return ApiResponse.error("上传文件失败了");
        }
    }
}
