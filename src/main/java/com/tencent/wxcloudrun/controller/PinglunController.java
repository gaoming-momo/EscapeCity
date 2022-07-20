package com.tencent.wxcloudrun.controller;

import com.alibaba.fastjson.JSONObject;
import com.tencent.wxcloudrun.config.ApiResponse;
import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.Message;
import com.tencent.wxcloudrun.model.Pinglun;
import com.tencent.wxcloudrun.service.DongtaiService;
import com.tencent.wxcloudrun.service.MessageService;
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
  @Autowired
  PinglunService pinglunService;
  @Autowired
  DongtaiService dongtaiService;
  @Autowired
  MessageService messageService;
  final Logger logger;

  public PinglunController() {
    this.logger = LoggerFactory.getLogger(PinglunController.class);
  }
  @RequestMapping(value = "/get")
  public ApiResponse get(@Param("id") Integer id){
    logger.error("pinglun get request:{}",id);
    Optional<Pinglun> pinglun = pinglunService.getById(id);
    return ApiResponse.ok(pinglun);
  }
  @RequestMapping(value = "/getByDid")
  public ApiResponse getByDid(@Param("did") Integer did){
    logger.error("pinglun getByDid request:{}",did);
    List<Pinglun> pinglunList = pinglunService.getByDid(did);
    return ApiResponse.ok(pinglunList);
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
    //有人评论了动态，那么给该动态的评论数加一
    Dongtai dongtai = dongtaiService.getById(pinglun.getDid());
    Integer pinglun_num = dongtai.getPinglun_num();
    pinglun_num = pinglun_num + 1;
    dongtai.setPinglun_num(pinglun_num);
    dongtaiService.update(dongtai);
    //同时给该动态的所有者发一条信息
    Message msg = new Message();
    msg.setType("pinglun");
    JSONObject msgJson = new JSONObject();
    msgJson.put("dongtai",JSONObject.toJSONString(dongtai));
    msgJson.put("pinglun",JSONObject.toJSONString(pinglun));
    msg.setMsg(msgJson.toJSONString());
    msg.setDid(dongtai.getId());
    msg.setFuid(dongtai.getUid());
    msg.setPid(pinglun.getId());
    messageService.insert(msg);
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