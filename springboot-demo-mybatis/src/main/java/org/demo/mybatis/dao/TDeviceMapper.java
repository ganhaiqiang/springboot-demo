package org.demo.mybatis.dao;

import org.demo.mybatis.model.TDevice;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface TDeviceMapper extends Mapper<TDevice>, IdsMapper<TDevice>, MySqlMapper<TDevice> {
}