package org.demo.web.controller;

import java.util.Date;

import org.apache.commons.lang3.time.FastDateFormat;
import org.springframework.stereotype.Service;

@Service
public class DemoService {

	public String getDate() {
		return FastDateFormat.getInstance("yyyy-MM-dd").format(new Date());
	}
}
