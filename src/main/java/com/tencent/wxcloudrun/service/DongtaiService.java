package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.User;

import java.util.Optional;

public interface DongtaiService {
  Optional<Dongtai> getById(String id);
  void insert(Dongtai dongtai);
  void delete(Dongtai dongtai);
}
