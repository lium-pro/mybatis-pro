package com.lium;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.lium.mapper"})
public class MybatisServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MybatisServiceApplication.class, args);
	}

}
