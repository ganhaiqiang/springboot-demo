package org.demo.mybatis.service;

import org.demo.mybatis.model.Student;

import com.github.pagehelper.PageInfo;

public interface StudentService {
	PageInfo<Student> selectByPage(int pageNum, int pageSize);

	int deleteByPrimaryKey(Integer id);

	int insert(Student record);

	int insertSelective(Student record);

	Student selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Student record);

	int updateByPrimaryKey(Student record);

	int updateSend(int id, int isSend);
}
