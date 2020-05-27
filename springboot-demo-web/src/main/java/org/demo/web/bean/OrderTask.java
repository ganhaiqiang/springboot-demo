package org.demo.web.bean;

import java.util.concurrent.BlockingQueue;

public class OrderTask implements Runnable {

	private BlockingQueue<String> queue;

	public OrderTask(BlockingQueue<String> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		try {
			String orderId = queue.take();
			System.out.println("orderId=" + orderId);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
