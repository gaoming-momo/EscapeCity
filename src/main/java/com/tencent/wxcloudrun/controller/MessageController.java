package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Message;
import com.tencent.wxcloudrun.service.MessageService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

/**
 * counter控制器
 */
@RestController
@RequestMapping("/api/msg")
public class MessageController {

  final MessageService messageService;
  final Logger logger;

  public MessageController(@Autowired MessageService messageService) {
    this.messageService = messageService;
    this.logger = LoggerFactory.getLogger(MessageController.class);
  }
  @RequestMapping(value = "/getbyid")
  public ApiResponse getUser(@Param("id") String id){
    Message msg = messageService.get(id);
    return ApiResponse.ok(msg);
  }

  /**
   * 新增用户
   * @param
   * @return
   */
  @PostMapping(value = "/insert")
  ApiResponse insert(@RequestBody Message msg) {
    logger.info("insert user get request");
    messageService.insert(msg);
    return ApiResponse.ok();
  }


  /**
   * 删除用户
   * @param msg
   * @return
   */
  @PostMapping(value = "/delete")
  ApiResponse create(@RequestBody Message msg) {
    logger.info("delete post request, action: {}",msg);
    messageService.delete(msg);
    return ApiResponse.ok(0);
  }
  
}