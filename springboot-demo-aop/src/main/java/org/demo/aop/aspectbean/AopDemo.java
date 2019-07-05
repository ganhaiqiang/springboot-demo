package org.demo.aop.aspectbean;

import java.lang.reflect.Method;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Order(-1)
@Component
public class AopDemo {

	@Before("execution(* org.demo.aop.service.*.*(..))")
//	@Before("@annotation(ds)")
	public void before(JoinPoint joinPoint/* , DataSource ds */) {
		MethodSignature sign = (MethodSignature) joinPoint.getSignature();
		Method method = sign.getMethod();
		// 获取方法上的注解
		DataSource annotation = method.getAnnotation(DataSource.class);
		if (annotation == null) {
			// 获取类上的注解
			annotation = joinPoint.getTarget().getClass().getAnnotation(DataSource.class);
			if (annotation == null) {
				// 获取接口上的注解
				for (Class<?> cls : joinPoint.getTarget().getClass().getInterfaces()) {
					System.out.println(cls.getName());
					annotation = cls.getAnnotation(DataSource.class);
					if (annotation != null) {
						System.out.println("获取类上的注解=" + annotation.value());
						break;
					}
				}
			}
		}
//		System.out.println("*********" + annotation.value() + "*********");
	}
}
