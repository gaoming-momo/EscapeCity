package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * counter控制器
 */
@RestController
@RequestMapping("/api/user")
public class UserController {

  final UserService userService;
  final Logger logger;

  public UserController(@Autowired UserService userService) {
    this.userService = userService;
    this.logger = LoggerFactory.getLogger(UserController.class);
  }
  @RequestMapping(value = "/getbyid")
  public ApiResponse getUser(@Param("id") String id){
    Optional<User> user = userService.getUser(id);
    return ApiResponse.ok(user);
  }

  /**
   * 新增用户
   * @param
   * @return
   */
  @PostMapping(value = "/insert")
  ApiResponse insert(@RequestBody User user) {
    logger.info("insert user get request");
    userService.insert(user);
    return ApiResponse.ok();
  }


  /**
   * 删除用户
   * @param user
   * @return
   */
  @PostMapping(value = "/delete")
  ApiResponse create(@RequestBody User user) {
    logger.info("delete post request, action: {}",user);
    userService.deleteUser(user);
    return ApiResponse.ok(0);
  }
  
}