package org.demo.webservice.cxf.server.config;

import javax.xml.ws.Endpoint;

import org.apache.cxf.Bus;
import org.apache.cxf.ext.logging.LoggingInInterceptor;
import org.apache.cxf.ext.logging.LoggingOutInterceptor;
import org.apache.cxf.jaxws.EndpointImpl;
import org.demo.webservice.cxf.server.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CxfConfig {
	@Autowired
	private TimeService timeService;

	@Autowired
	private Bus bus;

//	@Bean
//	public ServletRegistrationBean<CXFServlet> dispatcherServlet() {
//		return new ServletRegistrationBean<CXFServlet>(new CXFServlet(), "/soap/*");
//	}

	@Bean
	public Endpoint endpoint() {
		EndpointImpl endpoint = new EndpointImpl(bus, timeService);
		endpoint.publish("/timeService");

		endpoint.getInInterceptors().add(new LoggingInInterceptor());
		endpoint.getInInterceptors().add(new LoggingOutInterceptor());

		return endpoint;
	}
}
