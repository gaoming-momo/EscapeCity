package com.tencent.wxcloudrun.service;
import com.tencent.wxcloudrun.model.Pinglun;

import java.util.List;
import java.util.Optional;

public interface PinglunService {
  Optional<Pinglun> getById(Integer id);
  List<Pinglun> getByDid(Integer did);
  void insert(Pinglun pinglun);
  void delete(Pinglun pinglun);
  List<Pinglun> fetch(Integer currentPage, Integer pageSize);
  List<Pinglun> mine(Integer currentPage, Integer pageSize, String uid);
}
