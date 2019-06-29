package org.demo.multidatasource;

import org.demo.multidatasource.config.DynamicDataSourceRegister;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
@MapperScan("org.demo.multidatasource.dao")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}