package org.demo.aop.service;

import org.springframework.stereotype.Service;

@Service
public class DemoMapperImpl implements DemoMapper {

	@Override
	public void show() {
		System.out.println("======================show==================");
	}
}
