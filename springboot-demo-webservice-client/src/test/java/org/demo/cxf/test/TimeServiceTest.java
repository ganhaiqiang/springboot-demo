package org.demo.cxf.test;

import org.demo.cxf.client.Application;
import org.demo.cxf.client.utils.CxfUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
public class TimeServiceTest {

	@Test
	public void timeserviceTest() throws Exception {
		String wsdl = "http://localhost:8088/ws/timeService?wsdl";
		Object[] objects = CxfUtils.invoke(wsdl);
		System.out.println(objects[0]);
	}
}
