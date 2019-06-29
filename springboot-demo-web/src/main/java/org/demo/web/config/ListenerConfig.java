package org.demo.web.config;

import org.demo.web.listener.CustomerListener;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ListenerConfig {

	@Bean
	public ServletListenerRegistrationBean<CustomerListener> customerListenerRegistrationBean() {
		ServletListenerRegistrationBean<CustomerListener> servletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
		servletListenerRegistrationBean.setEnabled(true);
		servletListenerRegistrationBean.setListener(new CustomerListener());
		servletListenerRegistrationBean.setOrder(1);

		return servletListenerRegistrationBean;
	}
}
