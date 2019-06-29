package org.demo.multidatasource.config;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1) // 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {
	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	@Before("@within(ds)")
	public void changeDataSource(JoinPoint point, DataSource ds) throws Throwable {
		System.out.println("***********************************");
		String dsId = ds.value();
		if (!DynamicDataSourceContextHolder.containsDataSource(dsId)) {
			logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.value(), point.getSignature());
		} else {
			logger.debug("Use DataSource : {} > {}", ds.value(), point.getSignature());
			DynamicDataSourceContextHolder.setDataSourceType(ds.value());
		}
	}

	@After("@within(ds)")
	public void restoreDataSource(JoinPoint point, DataSource ds) {
		System.out.println("***********************************");
		logger.debug("Revert DataSource : {} > {}", ds.value(), point.getSignature());
		DynamicDataSourceContextHolder.clearDataSourceType();
	}

}
