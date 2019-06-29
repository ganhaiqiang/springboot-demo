package org.demo.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.demo.redis.Application;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.HyperLogLogOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class RedisTest {
	private static final Logger LOGGER = LoggerFactory.getLogger(RedisTest.class);

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	@Test
	public void valueTest() {
		redisTemplate.opsForValue().set("my.first.name", "甘海清", 20, TimeUnit.SECONDS);
		LOGGER.info((String) redisTemplate.opsForValue().get("my.first.name"));
	}

	@Test
	public void incrementTest() {
		redisTemplate.opsForValue().increment("number", 1L);
		System.out.println(redisTemplate.opsForValue().get("number"));// 结果：2
		redisTemplate.opsForValue().increment("number", 1L);
		System.out.println(redisTemplate.opsForValue().get("number"));// 结果：3
	}

	@Test
	public void hashTest() {
		Map<String, Object> map1 = new HashMap<>();
		map1.put("name", "甘海清");
		map1.put("age", 30);
		redisTemplate.opsForHash().putAll("hashmap", map1);
		Map<String, Object> map2 = new HashMap<>();
		map2.put("car", "奔驰");
		map2.put("price", 30000);
		redisTemplate.opsForHash().putAll("carmap", map2);

		Map<Object, Object> mapCache = redisTemplate.boundHashOps("hashmap").entries();
		System.out.println(JSON.toJSONString(mapCache, true));

		Map<Object, Object> carCache = redisTemplate.boundHashOps("carmap").entries();
		System.out.println(JSON.toJSONString(carCache, true));
	}

	@Test
	public void listTest() {
		redisTemplate.opsForList().rightPush("nameList", "张三");
		redisTemplate.opsForList().rightPush("nameList", "李四");

		List<Object> listCache = redisTemplate.boundListOps("nameList").range(0, 1);
		System.out.println(JSON.toJSONString(listCache, true));
	}

	@Test
	public void setTest() {
		redisTemplate.opsForSet().add("clazz", 100);
		redisTemplate.opsForSet().add("clazz", "com.ttl.hpc");

		Set<Object> setCache = redisTemplate.boundSetOps("clazz").members();
		System.out.println(JSON.toJSONString(setCache, true));
	}

	// 有序set集合
	@Test
	public void zsetTest() {
		redisTemplate.opsForZSet().add("tools", "notepad++", 2);
		redisTemplate.opsForZSet().add("tools", "vs", 3);
		redisTemplate.opsForZSet().add("tools", "eclipse", 1);

		Set<Object> setCache = redisTemplate.boundZSetOps("tools").rangeByScore(0, 3);
		System.out.println(JSON.toJSONString(setCache, true));
	}

	@Test
	public void hyperLogLogTest() {
		HyperLogLogOperations<String, Object> vo = redisTemplate.opsForHyperLogLog();
		System.out.println(vo.size("book"));
		System.out.println(vo.size("bag"));
		System.out.println(vo.size("del"));
		System.out.println(vo.size("book", "bag", "del"));
		vo.delete("del");
		System.out.println(vo.size("book", "bag", "del"));
		vo.union("total", "book", "bag", "del");
		System.out.println(vo.size("total"));
	}
}
