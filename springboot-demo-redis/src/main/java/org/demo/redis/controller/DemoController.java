package org.demo.redis.controller;

import java.util.UUID;
import java.util.concurrent.CountDownLatch;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
	private static final Logger LOGGER = LoggerFactory.getLogger(DemoController.class);

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;
	@Autowired
	private CountDownLatch countDownLatch;

	@RequestMapping("/uid")
	public String uid(HttpSession session) {
		UUID uid = (UUID) session.getAttribute("uid");
		if (uid == null) {
			uid = UUID.randomUUID();
		}
		session.setAttribute("uid", uid);
		return session.getId();
	}

	@GetMapping("sendMsg")
	public String sendMsg(String msg) throws InterruptedException {
		LOGGER.info("Sending message...");
		redisTemplate.convertAndSend("chat", msg);

		countDownLatch.await();
		return "OK";
	}

	@GetMapping("cacheTest")
	@Cacheable(value = "20sec", key = "#name")
	public String getName(String name) {
		System.out.println("缓存失效");
		return "Hello," + name;
	}
}
