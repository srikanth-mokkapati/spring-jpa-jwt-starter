package com.starter.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan( basePackages = {"com.starter.app"})
public class SpringJwtJpaStarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJwtJpaStarterApplication.class, args);
	}

}
