package org.demo.shiro.config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class DruidConfig {
	/**
	 * druid监控页面登录用户名、密码
	 * 
	 * @return
	 */
	@Bean
	public ServletRegistrationBean<StatViewServlet> druidServlet() {
		ServletRegistrationBean<StatViewServlet> servletRegistrationBean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(), "/druid/*");
		// 登录查看信息的账号密码.

		servletRegistrationBean.addInitParameter("loginUsername", "admin");

		servletRegistrationBean.addInitParameter("loginPassword", "123456");
		return servletRegistrationBean;
	}

	@Bean
	public FilterRegistrationBean<WebStatFilter> filterRegistrationBean() {
		FilterRegistrationBean<WebStatFilter> filterRegistrationBean = new FilterRegistrationBean<WebStatFilter>();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		return filterRegistrationBean;
	}
}
