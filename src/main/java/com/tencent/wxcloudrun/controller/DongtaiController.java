package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.DongtaiService;
import com.tencent.wxcloudrun.service.PinglunService;
import com.tencent.wxcloudrun.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

/**
 * counter控制器
 */
@RestController
@RequestMapping("/api/dongtai")
public class DongtaiController {

  final DongtaiService dongtaiService;
  final Logger logger;

  public DongtaiController(@Autowired DongtaiService dongtaiService) {
    this.dongtaiService = dongtaiService;
    this.logger = LoggerFactory.getLogger(DongtaiController.class);
  }
  @RequestMapping(value = "/get")
  public ApiResponse get(@Param("id") String id){
    Optional<Dongtai> dongtai = dongtaiService.getById(id);
    return ApiResponse.ok(dongtai);
  }

  /**
   *
   * @param
   * @return
   */
  @PostMapping(value = "/add")
  ApiResponse get(@RequestBody Dongtai dongtai) {
    logger.info("add get request");
    dongtaiService.insert(dongtai);
    return ApiResponse.ok();
  }
  @RequestMapping(value = "/fabu")
  public ApiResponse uploadFiles(String fileIds, String openid, String text,
                                 String nickName, String avatarUrl, String location)  {
    logger.error("收到上传请求 /fabu");
    logger.error("openid：" + openid);
    logger.error("text：" + text);
    logger.error("fileIds：" + fileIds);
    logger.error("avatarUrl : "+avatarUrl);
    logger.error("location : "+location);
    Dongtai dongtai = new Dongtai(openid, text, nickName, avatarUrl, fileIds,location);
    logger.error("dongtai;:{}",dongtai);
    dongtaiService.insert(dongtai);
    return ApiResponse.ok();
  }
  @RequestMapping(value = "/fetch")
  public ApiResponse getDataPage(Integer currentPage, Integer pageSize){
    logger.error("收到请求： /fetch");
    logger.error("currentPage: "+ currentPage + "  , pageSize: " + pageSize);
    currentPage = currentPage * pageSize ;
    List<Dongtai> dongtaiList = dongtaiService.fetch(currentPage, pageSize);
    return ApiResponse.ok(dongtaiList);
  }

  /**
   * 我的动态（已发布）
   * @param currentPage
   * @param pageSize
   * @return
   */
  @RequestMapping(value = "/mine")
  public ApiResponse mine(Integer currentPage, Integer pageSize, String uid){
    logger.error("收到请求： /fetch");
    logger.error("currentPage: "+ currentPage + "  , pageSize: " + pageSize + " uid:" + uid);
    currentPage = currentPage * pageSize ;
    List<Dongtai> dongtaiList = dongtaiService.mine(currentPage, pageSize, uid);
    return ApiResponse.ok(dongtaiList);
  }

  /**
   * 删除
   * @param
   * @return
   */
  @PostMapping(value = "/delete")
  ApiResponse create(@RequestBody Dongtai dongtai) {
    logger.info("delete post request, action: {}",dongtai);
    dongtaiService.delete(dongtai);
    return ApiResponse.ok(0);
  }
  
}