package org.demo.multidatasource.dao;

import org.demo.multidatasource.config.DataSource;
import org.demo.multidatasource.entity.Student;
import tk.mybatis.mapper.common.Mapper;

@DataSource("test")
public interface StudentMapper extends Mapper<Student> {
}