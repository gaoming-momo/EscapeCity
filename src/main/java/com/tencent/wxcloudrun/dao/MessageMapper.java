package com.tencent.wxcloudrun.dao;

import com.tencent.wxcloudrun.model.Message;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MessageMapper {

  Message get(@Param("id") String id);

  void insert(Message message);

  void delete(Message message);

  List<Message> getByFuid(String fuid);
}
