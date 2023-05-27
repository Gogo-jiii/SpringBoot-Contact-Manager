package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.example.demo.dao.UserRepo;

@SpringBootApplication(scanBasePackages = {"com.example.demo", "com.example.dao", "com.example.controller", "com.example.models", "com.example.config"} )
public class ContactManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ContactManagerApplication.class, args);

		System.out.println("Server started...");
	}

}
