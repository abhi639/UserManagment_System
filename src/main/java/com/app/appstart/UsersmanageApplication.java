package com.app.appstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories(basePackages = "com.app.appstart.repository")
public class UsersmanageApplication {

	public static void main(String[] args) {
		SpringApplication.run(UsersmanageApplication.class, args);
	}

}
