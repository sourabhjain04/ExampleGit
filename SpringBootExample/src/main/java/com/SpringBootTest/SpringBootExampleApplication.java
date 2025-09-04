package com.SpringBootTest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootExampleApplication {

	public static void main(String[] args) {
		System.out.println("Hello, World!");
		System.out.println("Hello, World!1");

		SpringApplication.run(SpringBootExampleApplication.class, args);
	}

}
