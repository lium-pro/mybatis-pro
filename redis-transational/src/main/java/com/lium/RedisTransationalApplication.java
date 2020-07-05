package com.lium;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication()
@MapperScan(value = {"com.lium.mapper"})
class RedisTransationalApplication {

	public static void main(String[] args) {
		SpringApplication.run(RedisTransationalApplication.class, args);
	}

}
