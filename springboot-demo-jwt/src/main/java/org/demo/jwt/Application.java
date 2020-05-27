package org.demo.jwt;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements BeanPostProcessor {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("*******" + beanName + "*******");
		return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
	}

}
