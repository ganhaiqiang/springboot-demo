package org.demo.test;

import java.io.IOException;
import java.util.Properties;

import org.demo.web.Application;
import org.demo.web.controller.DemoService;
import org.demo.web.utils.SpringContextUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(value = SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class ReadPropertyTest {

	@Test
	public void test() throws IOException {
		Properties properties = PropertiesLoaderUtils.loadAllProperties("application.properties");
		System.out.println(properties.getProperty("spring.thymeleaf.prefix"));
	}

	@Test
	public void testSpring() throws IOException {
		DemoService service = SpringContextUtil.getBean(DemoService.class);
		System.out.println(service.getDate());
	}
}
