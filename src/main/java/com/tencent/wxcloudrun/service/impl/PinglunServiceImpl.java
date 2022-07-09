package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.PinglunMapper;
import com.tencent.wxcloudrun.model.Pinglun;
import com.tencent.wxcloudrun.service.PinglunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PinglunServiceImpl implements PinglunService {
  final PinglunMapper pinglunMapper;

  public PinglunServiceImpl(@Autowired PinglunMapper pinglunMapper) {
    this.pinglunMapper = pinglunMapper;
  }

  @Override

  public Optional<Pinglun> getById(String id) {
    Pinglun pinglun = pinglunMapper.getById(id);
    return Optional.ofNullable(pinglun);
  }

  @Override
  public void insert(Pinglun pinglun) {
    pinglunMapper.insert(pinglun);
  }

  @Override
  public void delete(Pinglun pinglun) {
    pinglunMapper.delete(pinglun);
  }

  @Override
  public List<Pinglun> fetch(Integer currentPage, Integer pageSize) {
    return pinglunMapper.fetch(currentPage, pageSize);
  }

  @Override
  public List<Pinglun> mine(Integer currentPage, Integer pageSize, String uid) {
    return pinglunMapper.mine(currentPage, pageSize, uid);
  }

}
