package com.tencent.wxcloudrun.service.impl;

import com.tencent.wxcloudrun.dao.DongtaiMapper;
import com.tencent.wxcloudrun.dao.UserMapper;
import com.tencent.wxcloudrun.model.Dongtai;
import com.tencent.wxcloudrun.model.User;
import com.tencent.wxcloudrun.service.DongtaiService;
import com.tencent.wxcloudrun.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DongtaiServiceImpl implements DongtaiService {
  final DongtaiMapper dongtaiMapper;

  public DongtaiServiceImpl(@Autowired DongtaiMapper dongtaiMapper) {
    this.dongtaiMapper = dongtaiMapper;
  }

  @Override

  public Optional<Dongtai> getById(String id) {
    Dongtai dongtai = dongtaiMapper.getById(id);
    return Optional.ofNullable(dongtai);
  }

  @Override
  public void insert(Dongtai dongtai) {
    dongtaiMapper.insert(dongtai);
  }

  @Override
  public void delete(Dongtai dongtai) {
    dongtaiMapper.delete(dongtai);
  }

  @Override
  public List<Dongtai> fetch(Integer currentPage, Integer pageSize) {
    return dongtaiMapper.fetch(currentPage, pageSize);
  }

}
