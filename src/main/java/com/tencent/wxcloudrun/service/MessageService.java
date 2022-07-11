package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Message;

public interface MessageService {

  Message get(String id);

  void insert(Message msg);

  void delete(Message msg);
}
