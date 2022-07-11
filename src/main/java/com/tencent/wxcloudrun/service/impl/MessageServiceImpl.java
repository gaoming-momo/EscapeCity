package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.MessageMapper;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.Message;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.MessageService;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MessageServiceImpl implements MessageService {
  final MessageMapper messageMapper;

  public MessageServiceImpl(@Autowired MessageMapper messageMapper) {
    this.messageMapper = messageMapper;
  }

  @Override
  public Message get(String id) {
    Message msg = messageMapper.get(id);
    return msg;
  }

  @Override
  public void insert(Message msg) {
    messageMapper.insert(msg);
  }

  @Override
  public void delete(Message msg) {
    messageMapper.delete(msg);
  }
}
