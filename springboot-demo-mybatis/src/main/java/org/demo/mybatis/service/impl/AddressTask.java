package org.demo.mybatis.service.impl;

import java.util.List;
import java.util.Map;
import java.util.concurrent.Callable;

import org.demo.mybatis.service.StudentService;

public class AddressTask implements Callable<List<Map<String, String>>> {
	private List<Map<String, String>> addressList;
	private StudentService studentService;

	public AddressTask(List<Map<String, String>> addressList, StudentService studentService) {
		super();
		this.addressList = addressList;
		this.studentService = studentService;
	}

	@Override
	public List<Map<String, String>> call() throws Exception {
		int index=0;
		for (int i = 0; i < addressList.size(); i++) {
//			try {
//				Thread.sleep(100);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
			index++;
			if (index==500) {
				studentService.updateSend(1, index);
				index=0;
			}
		}
		return addressList;
	}

}
