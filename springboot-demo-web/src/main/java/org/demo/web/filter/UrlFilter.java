package org.demo.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UrlFilter implements Filter {
	private static final Logger LOGGER = LoggerFactory.getLogger(UrlFilter.class);

	@Override
	public void destroy() {

	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURL().toString();
		LOGGER.info("【URL={}】", url);

		chain.doFilter(arg0, arg1);
	}

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		String env = filterConfig.getInitParameter("env");
		String version = filterConfig.getInitParameter("version");
		LOGGER.info("初始化参数：【env={},version={}】", env, version);
	}

}
