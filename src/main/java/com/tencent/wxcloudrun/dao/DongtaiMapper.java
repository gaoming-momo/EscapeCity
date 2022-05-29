package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface DongtaiMapper {

  Dongtai getById(@Param("id") String id);

  void insert(Dongtai dongtai);

  void delete(Dongtai dongtai);
}
