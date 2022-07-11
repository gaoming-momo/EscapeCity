package com.tencent.wxcloudrun.model;

import lombok.Data;

import java.io.Serializable;

@Data
public class Message implements Serializable {

  private Integer id;

  private String type;

  private String msg;
}
