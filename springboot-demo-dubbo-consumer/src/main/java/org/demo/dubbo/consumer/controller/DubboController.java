package org.demo.dubbo.consumer.controller;

import org.demo.dubbo.service.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.dubbo.config.annotation.Reference;

@RestController
public class DubboController {

	@Reference(version = "${demo.service.version}", application = "${dubbo.application.id}"/*, url = "dubbo://localhost:12345"*/)
	private DubboService dubboService;

	@GetMapping("getDateString")
	private String getDateString() {
		return dubboService.getDateString();
	}
}
