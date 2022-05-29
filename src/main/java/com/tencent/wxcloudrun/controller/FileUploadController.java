package com.tencent.wxcloudrun.controller;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.region.Region;
import com.tencent.wxcloudrun.config.ApiResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileUploadController {

    @RequestMapping(value = "/uploadFiles")
    public ApiResponse uploadFiles(){

        return ApiResponse.ok();
    }
}
