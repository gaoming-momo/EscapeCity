package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
  final UserMapper userMapper;

  public UserServiceImpl(@Autowired UserMapper userMapper) {
    this.userMapper = userMapper;
  }

  @Override
  public Optional<User> getUser(String user_id) {
    User user = userMapper.getUser(user_id);
    return Optional.ofNullable(user);
  }

  @Override
  public void insert(User user) {
    userMapper.insert(user);
  }

  @Override
  public void deleteUser(User user) {
    userMapper.deleteUser(user);
  }
}
