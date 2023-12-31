package com.example.SpringVol2;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.SpringVol2.mapper")
public class SpringVol2Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringVol2Application.class, args);
	}

}
