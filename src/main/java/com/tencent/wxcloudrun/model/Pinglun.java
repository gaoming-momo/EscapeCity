package com.tencent.wxcloudrun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Pinglun implements Serializable {
  public Pinglun(String uid, String fuid, String did, String text,
                 String nickName, String avatarUrl, Integer level,
                 Integer dian_zan, String location){
    this.uid = uid;
    this.fuid = fuid;
    this.did = did;
    this.text = text;
    this.nickName = nickName;
    this.avatarUrl = avatarUrl;
    this.level = level;
    this.dian_zan = dian_zan;
    this.location = location;

  }
  private Integer id;
  private String uid;
  private String fuid;
  private String did;
  private String text;
  private String nickName;
  private String avatarUrl;
  private Integer level;
  private Integer dian_zan;
  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;
  private String location;
}
