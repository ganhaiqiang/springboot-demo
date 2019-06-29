package org.demo.dubbo.provider.service;

import org.demo.dubbo.service.DubboService;
import org.joda.time.DateTime;

import com.alibaba.dubbo.config.annotation.Service;

@Service(version = "${demo.service.version}", application = "${dubbo.application.id}", protocol = "${dubbo.protocol.id}", registry = "${dubbo.registry.id}")
public class DubboServiceImpl implements DubboService {

	@Override
	public String getDateString() {
		return "现在时间是：" + DateTime.now().toString("yyyy-MM-dd HH:mm:ss");
	}

}
