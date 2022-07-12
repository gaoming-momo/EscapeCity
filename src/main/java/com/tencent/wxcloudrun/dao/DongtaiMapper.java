package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DongtaiMapper {

  Dongtai getById(@Param("id") String id);

  Dongtai getByUid(@Param("uid") String uid);

  void insert(Dongtai dongtai);

  void delete(Dongtai dongtai);

  List<Dongtai> fetch(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

  List<Dongtai> mine(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize , @Param("uid") String uid);
}
