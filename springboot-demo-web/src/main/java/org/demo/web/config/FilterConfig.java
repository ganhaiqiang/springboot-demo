package org.demo.web.config;

import org.demo.web.filter.UrlFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

	@Bean
	public FilterRegistrationBean<UrlFilter> urlFilterRegistrationBean() {
		FilterRegistrationBean<UrlFilter> filterRegistrationBean = new FilterRegistrationBean<>();
		filterRegistrationBean.setEnabled(true);
		filterRegistrationBean.setFilter(new UrlFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.setName("Filter-urlFilter");
		filterRegistrationBean.addInitParameter("env", "test");
		filterRegistrationBean.addInitParameter("version", "1.0.0");
		filterRegistrationBean.setOrder(1);
		return filterRegistrationBean;
	}
}
