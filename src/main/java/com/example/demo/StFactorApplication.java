package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan(value = "com.example.demo.mapper")
@ComponentScan("com.example.demo.action")
@ComponentScan("com.example.demo.api")
public class StFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StFactorApplication.class, args);
	}
}
