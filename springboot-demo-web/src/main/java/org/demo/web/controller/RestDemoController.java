package org.demo.web.controller;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.demo.web.bean.OrderTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("rest")
public class RestDemoController {

	@Autowired
	private ThreadPoolTaskExecutor threadPoolTaskExecutor;

	private BlockingQueue<String> batchQueue = new LinkedBlockingQueue<String>(3);

	@RequestMapping("order")
	public Object order(String orderId) throws InterruptedException {
		batchQueue.add(orderId);
		OrderTask task = new OrderTask(batchQueue);
		threadPoolTaskExecutor.execute(task);
		return orderId;
	}

	@RequestMapping("get")
	public Object element() throws InterruptedException {
		return batchQueue.element();
	}
}
