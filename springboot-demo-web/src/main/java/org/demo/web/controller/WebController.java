package org.demo.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.demo.web.utils.SpringContextUtil;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class WebController {

	@GetMapping("/")
	public ModelAndView gotoIndex(HttpServletRequest request, ModelMap map) {
		map.put("projectName", request.getServletContext().getAttribute("projectName"));
		map.put("user", "thymeleaf");
		return new ModelAndView("index", "user", "thymeleaf");
	}

	@GetMapping("/getDate")
	@ResponseBody
	public Object getDate() {
		DemoService service = SpringContextUtil.getBean(DemoService.class);
		return service.getDate();
	}
}
