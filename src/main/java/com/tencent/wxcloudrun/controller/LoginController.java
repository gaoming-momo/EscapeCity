package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.dto.CounterRequest;
import com.tencent.wxcloudrun.model.Counter;
import com.tencent.wxcloudrun.service.CounterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

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
  ApiResponse get(String code) {
    logger.info("/login get request");
    logger.error("收到参数code:{}",code);
    Integer count = 0;
    return ApiResponse.ok(count);
  }
}