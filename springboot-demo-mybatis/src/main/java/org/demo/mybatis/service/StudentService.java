package org.demo.mybatis.service;

import java.util.List;

import org.demo.mybatis.model.Student;

public interface StudentService {
	List<Student> selectByPage();

	int deleteByPrimaryKey(Integer id);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);

	int updateSend(int id, int isSend);
}
