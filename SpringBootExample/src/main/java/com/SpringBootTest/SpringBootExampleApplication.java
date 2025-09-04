package com.SpringBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

}
