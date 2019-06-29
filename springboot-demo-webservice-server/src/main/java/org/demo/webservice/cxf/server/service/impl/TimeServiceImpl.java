package org.demo.webservice.cxf.server.service.impl;

import javax.jws.WebService;

import org.demo.webservice.cxf.server.service.TimeService;
import org.joda.time.DateTime;
import org.springframework.stereotype.Component;

@WebService(serviceName = "timeService"// 服务名
		, targetNamespace = "http://service.server.cxf.webservice.demo.org"// 报名倒叙，并且和接口定义保持一致
		, endpointInterface = "org.demo.webservice.cxf.server.service.TimeService")
@Component
public class TimeServiceImpl implements TimeService {

	@Override
	public String getServerDate() {
		return "服务器当前时间：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
	}

}
