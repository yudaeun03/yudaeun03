package com.kh.springajax;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.kh.springajax")
@SpringBootApplication
public class Spring11ajaxApplication {

	public static void main(String[] args) {
		SpringApplication.run(Spring11ajaxApplication.class, args);
	}

}
