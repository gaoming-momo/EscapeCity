package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface DongtaiService {
  Dongtai getById(Integer id);
  Dongtai getByUid(String uid);
  void insert(Dongtai dongtai);
  void update(Dongtai dongtai);
  void delete(Dongtai dongtai);
  List<Dongtai> fetch(Integer currentPage, Integer pageSize);
  List<Dongtai> mine(Integer currentPage, Integer pageSize, String uid);
}
