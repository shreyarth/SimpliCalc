package com.springbootphase3end;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan(basePackages = "com")
@EntityScan(basePackages = "com")
public class Springbootphase3endApplication {

	public static void main(String[] args) {
		SpringApplication.run(Springbootphase3endApplication.class, args);
	}

}
