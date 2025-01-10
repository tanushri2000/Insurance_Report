package com.ies;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.tanu")
public class ReportsApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReportsApiApplication.class, args);
	}

}
