package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import org.springframework.jmx.support.RegistrationPolicy;
import org.springframework.context.annotation.EnableMBeanExport;

import com.github.tobato.fastdfs.FdfsClientConfig;


@Import(FdfsClientConfig.class)
@EnableMBeanExport(registration = RegistrationPolicy.IGNORE_EXISTING)

@SpringBootApplication
@MapperScan(value = "com.example.demo.mapper")
@ComponentScan("com.example.demo.action")
@ComponentScan("com.example.demo.api")
public class StFactorApplication {

	public static void main(String[] args) {
		SpringApplication.run(StFactorApplication.class, args);
	}
}
