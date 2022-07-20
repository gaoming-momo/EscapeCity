package com.tencent.wxcloudrun.service;

import com.tencent.wxcloudrun.model.Message;

import java.util.List;

public interface MessageService {

  Message get(String id);

  List<Message> getByFuid(String fuid);

  void insert(Message msg);

  void delete(Message msg);
}
