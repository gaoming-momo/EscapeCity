package com.tencent.wxcloudrun.controller;

import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.Pinglun;
import com.tencent.wxcloudrun.service.DongtaiService;
import com.tencent.wxcloudrun.service.PinglunService;
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
@RequestMapping("/api/pinglun")
public class PinglunController {

  final PinglunService pinglunService;
  final DongtaiService dongtaiService;
  final Logger logger;

  public PinglunController(@Autowired PinglunService pinglunService , @Autowired DongtaiService dongtaiService) {
    this.pinglunService = pinglunService;
    this.dongtaiService = dongtaiService;
    this.logger = LoggerFactory.getLogger(PinglunController.class);
  }
  @RequestMapping(value = "/get")
  public ApiResponse get(@Param("id") String id){
    Optional<Pinglun> pinglun = pinglunService.getById(id);
    return ApiResponse.ok(pinglun);
  }

  /**
   *
   * @param
   * @return
   */
  @PostMapping(value = "/add")
  ApiResponse get(@RequestBody Pinglun pinglun) {
    logger.error("add get request:{}",pinglun);
    pinglunService.insert(pinglun);
    Dongtai dongtai = dongtaiService.getById(pinglun.getDid());
    Integer pinglun_num = dongtai.getPinglun_num();
    pinglun_num = pinglun_num + 1;
    dongtai.setPinglun_num(pinglun_num);
    dongtaiService.insert(dongtai);
    return ApiResponse.ok();
  }
  @RequestMapping(value = "/fabu")
  public ApiResponse uploadFiles(String uid, String fiud,  Integer did, String text,
                                 String nickName, String avatarUrl,Integer level,Integer dian_zan, String location)  {
    logger.error("收到上传请求 /fabu");
    logger.error("uid：" + uid);
    logger.error("text：" + text);
    logger.error("fid：" + fiud);
    logger.error("avatarUrl : "+avatarUrl);
    logger.error("location : "+location);
    Pinglun pinglun = new Pinglun(uid, fiud, did, text,nickName,avatarUrl,level,dian_zan,location);
    pinglunService.insert(pinglun);
    return ApiResponse.ok();
  }
  @RequestMapping(value = "/fetch")
  public ApiResponse getDataPage(Integer currentPage, Integer pageSize){
    logger.error("收到请求： /fetch");
    logger.error("currentPage: "+ currentPage + "  , pageSize: " + pageSize);
    currentPage = currentPage * pageSize ;
    List<Pinglun> pinglunList = pinglunService.fetch(currentPage, pageSize);
    return ApiResponse.ok(pinglunList);
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
    List<Pinglun> pinglunList = pinglunService.mine(currentPage, pageSize, uid);
    return ApiResponse.ok(pinglunList);
  }

  /**
   * 删除
   * @param
   * @return
   */
  @PostMapping(value = "/delete")
  ApiResponse create(@RequestBody Pinglun pinglun) {
    logger.info("delete post request, action: {}",pinglun);
    pinglunService.delete(pinglun);
    return ApiResponse.ok(0);
  }
  
}