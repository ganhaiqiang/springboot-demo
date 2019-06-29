package org.demo.mybatis.dao;

import org.demo.mybatis.model.Student;

import tk.mybatis.mapper.common.IdsMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

public interface StudentMapper extends Mapper<Student>, IdsMapper<Student>, MySqlMapper<Student> {
}