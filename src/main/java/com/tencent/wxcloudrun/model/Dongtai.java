package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Dongtai implements Serializable {
  public Dongtai(String openId, String text, String media_list){
      this.uid = openId;
      this.text = text;
      this.media_list = media_list;
  }

  private Integer id;
  private String uid;
  private String media_list;
  private String text;
  private Integer shoucang_num;
  private Integer dian_zan;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
}
