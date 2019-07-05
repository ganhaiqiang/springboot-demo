package org.demo.aop.controller;

import org.demo.aop.service.DemoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private DemoMapper demoMapper;

	@GetMapping("test")
	public Object demo() {
		demoMapper.show();
		return "ok";
	}
}
