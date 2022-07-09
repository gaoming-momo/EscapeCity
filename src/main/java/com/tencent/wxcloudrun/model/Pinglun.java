package com.tencent.wxcloudrun.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Builder
public class Pinglun implements Serializable {
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
