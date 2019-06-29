package org.demo.web.config;

import org.demo.web.servlet.VersionServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServletConfig {

	@Bean
	public ServletRegistrationBean<VersionServlet> registerServletRegistrationBean() {
		ServletRegistrationBean<VersionServlet> servletRegistrationBean = new ServletRegistrationBean<>();
		servletRegistrationBean.setEnabled(true);
		servletRegistrationBean.setServlet(new VersionServlet());
		servletRegistrationBean.setName("versionServlet");
		servletRegistrationBean.addUrlMappings("/getVersion");
		servletRegistrationBean.setOrder(1);
		return servletRegistrationBean;
	}
}
