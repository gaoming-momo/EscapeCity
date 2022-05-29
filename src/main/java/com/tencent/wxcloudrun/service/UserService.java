package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.User;

import java.util.Optional;

public interface UserService {

  Optional<User> getUser(String user_id);

  void insert(User user);

  void deleteUser(User user);
}
