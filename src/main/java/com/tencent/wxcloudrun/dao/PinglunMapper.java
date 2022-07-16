package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Pinglun;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface PinglunMapper {

  Pinglun getById(@Param("id") Integer id);

  void insert(Pinglun pinglun);

  void delete(Pinglun pinglun);

  List<Pinglun> fetch(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize);

  List<Pinglun> mine(@Param("currentPage") Integer currentPage, @Param("pageSize") Integer pageSize, @Param("uid") String uid);
}
