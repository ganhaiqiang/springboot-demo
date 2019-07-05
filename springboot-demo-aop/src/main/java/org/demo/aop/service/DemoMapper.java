package org.demo.aop.service;

import org.demo.aop.aspectbean.DataSource;

@DataSource("aaa")
public interface DemoMapper {

	void show();
}
