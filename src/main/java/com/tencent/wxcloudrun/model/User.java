package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class User implements Serializable {

  private Integer id;

  private String nick_name;

  private String user_id;
}
