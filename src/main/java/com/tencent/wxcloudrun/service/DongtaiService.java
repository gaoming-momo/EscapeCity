package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

public interface DongtaiService {
  Optional<Dongtai> getById(String id);
  void insert(Dongtai dongtai);
  void delete(Dongtai dongtai);
  List<Dongtai> fetch(Integer currentPage, Integer pageSize);
  List<Dongtai> mine(Integer currentPage, Integer pageSizek, String uid);
}
