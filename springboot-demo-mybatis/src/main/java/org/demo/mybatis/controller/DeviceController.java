package org.demo.mybatis.controller;

import org.demo.mybatis.dao.StudentMapper;
import org.demo.mybatis.dao.TDeviceMapper;
import org.demo.mybatis.model.Student;
import org.demo.mybatis.model.TDevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeviceController {

	@Autowired
	private TDeviceMapper tDeviceMapper;
	@Autowired
	private StudentMapper studentMapper;

	@RequestMapping("getDevice")
	public Object getDevice() {
		TDevice record = new TDevice();
		record.setId(1);
		return tDeviceMapper.select(record);
	}

	@RequestMapping("insertStudent")
	public Object insertStudent() {
		Student student = new Student();
		student.setAge(55);
		student.setName("张宝图");
		studentMapper.insert(student);
		return student;
	}

	@RequestMapping("deleteByIds")
	public Object deleteByIds(String ids) {
		return studentMapper.deleteByIds(ids);
	}
}
