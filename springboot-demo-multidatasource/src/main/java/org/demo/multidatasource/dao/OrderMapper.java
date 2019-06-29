package org.demo.multidatasource.dao;

import org.demo.multidatasource.config.DataSource;
import org.demo.multidatasource.entity.Order;
import tk.mybatis.mapper.common.Mapper;

@DataSource("ssh")
public interface OrderMapper extends Mapper<Order> {
}