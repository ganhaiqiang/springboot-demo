package org.demo.mybatis.dao;

import org.demo.mybatis.model.Student;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.ids.DeleteByIdsMapper;

public interface StudentMapper extends Mapper<Student>,DeleteByIdsMapper<Student> {
}