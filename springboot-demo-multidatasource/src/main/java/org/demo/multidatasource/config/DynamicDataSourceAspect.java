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
@Order(-100) // 保证该AOP在@Transactional之前执行
@Component
public class DynamicDataSourceAspect {
	private static final Logger logger = LoggerFactory.getLogger(DynamicDataSourceAspect.class);

	@Before("execution(* org.demo.multidatasource.dao.*.*(..))")
	public void changeDataSource(JoinPoint joinPoint) throws Throwable {
		for (Class<?> cls : joinPoint.getTarget().getClass().getInterfaces()) {
			System.out.println(cls.getName());
			DataSource ds = cls.getAnnotation(DataSource.class);
			if (ds != null) {
				if (!DynamicDataSourceContextHolder.containsDataSource(ds.value())) {
					logger.error("数据源[{}]不存在，使用默认数据源 > {}", ds.value(), joinPoint.getSignature());
				} else {
					logger.debug("Use DataSource : {} > {}", ds.value(), joinPoint.getSignature());
					DynamicDataSourceContextHolder.setDataSourceType(ds.value());
				}
				break;
			}
		}
	}

	@After("execution(* org.demo.multidatasource.dao.*.*(..))")
	public void restoreDataSource(JoinPoint joinPoint) {
		DynamicDataSourceContextHolder.clearDataSourceType();
	}

}
