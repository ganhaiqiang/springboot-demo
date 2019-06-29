package org.demo.multidatasource.controller;

import org.demo.multidatasource.dao.OrderMapper;
import org.demo.multidatasource.dao.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Demo2Controller {

	@Autowired
	private StudentMapper studentMapper;
	@Autowired
	private OrderMapper orderMapper;

	@RequestMapping("getStudent")
	public Object getStudent(Integer id) {
		return studentMapper.selectByPrimaryKey(id);
	}

	@RequestMapping("getOrder")
	public Object getOrder(Long id) {
		return orderMapper.selectByPrimaryKey(id);
	}
}
