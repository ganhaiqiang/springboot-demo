package org.demo.caffeine.controller;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class DemoController {

	@GetMapping("getName")
	@ResponseBody
	@Cacheable(value = "caffeine", key = "'DemoController'+'#name'", sync = true)
	public String ache(String name) {
		System.out.println("缓存失效。。。");
		return "输入的名字是：" + name;
	}
}
