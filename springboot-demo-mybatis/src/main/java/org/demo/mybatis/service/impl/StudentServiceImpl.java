package org.demo.mybatis.service.impl;

import java.util.List;

import org.demo.mybatis.dao.StudentMapper;
import org.demo.mybatis.model.Student;
import org.demo.mybatis.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentMapper studentMapper;

	@Override
	public PageInfo<Student> selectByPage(int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize, true);

		List<Student> students = studentMapper.selectAll();

		return new PageInfo<>(students);
	}

	@Override
	public int deleteByPrimaryKey(Integer id) {
		return studentMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Student record) {
		return studentMapper.insert(record);
	}

	@Override
	public int insertSelective(Student record) {
		return studentMapper.insertSelective(record);
	}

	@Override
	public Student selectByPrimaryKey(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Student record) {
		return studentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Student record) {
		return studentMapper.updateByPrimaryKey(record);
	}

	@Override
	public int updateSend(int id, int isSend) {
//		return studentMapper.updateSend(id, isSend);
		return 0;
	}

}
