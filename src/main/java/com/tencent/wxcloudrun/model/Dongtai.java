package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Dongtai implements Serializable {
  public Dongtai(String openId, String text, String nickName, String avatarUrl, String media_list, String location){
      this.uid = openId;
      this.text = text;
      this.nickName = nickName;
      this.avatarUrl = avatarUrl;
      this.media_list = media_list;
      this.location = location;
  }

  private Integer id;
  private String uid;
  private String media_list;
  private String text;
  private String nickName;
  private String avatarUrl;
  private Integer shoucang_num;
  private Integer dian_zan;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String location;
}
