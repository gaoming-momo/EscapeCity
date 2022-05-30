package com.tencent.wxcloudrun.controller;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.constant.Common;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * counter控制器
 */
@RestController
public class LoginController {
  final Logger logger;

  public LoginController() {
    this.logger = LoggerFactory.getLogger(LoginController.class);
  }


  /**
   * 处理登录
   * @return API response json
   */
  @GetMapping(value = "/login")
  ApiResponse get(String code) throws IOException {
    logger.info("/login get request");
    logger.error("收到参数code:{}",code);
    //登录凭证不能为空
    if (code == null || code.length() == 0) {
      return ApiResponse.error("code 不能为空");
    }
    //小程序唯一标识   (在微信小程序管理后台获取)
    String wxspAppid = Common.APP_ID;
    //小程序的 app secret (在微信小程序管理后台获取)
    String wxspSecret = Common.secretId;
    //授权（必填）
    String grant_type = "authorization_code";
    String url = "https://api.weixin.qq.com/sns/jscode2session";
    //https://api.weixin.qq.com/sns/jscode2session?appid=APPID&secret=SECRET&js_code=JSCODE&grant_type=authorization_code
    //1、向微信服务器 使用登录凭证 code 获取 session_key 和 openid
    //请求参数
    String params = "appid=" + wxspAppid + "&secret=" + wxspSecret + "&js_code=" + code + "&grant_type=" + grant_type;
    url = url + "?" + params;
    //发送请求
    OkHttpClient client = new OkHttpClient();
    //用url发起请求
    Request request = new Request.Builder().url(url).build();
    //拿到响应
    Response response = client.newCall(request).execute();
    logger.error("response:{}",response);
    //解析相应内容（转换成json对象）
    return ApiResponse.ok(response);
  }
}