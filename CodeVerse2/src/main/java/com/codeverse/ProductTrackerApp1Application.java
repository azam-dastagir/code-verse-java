package com.codeverse;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.codeverse.entity")
public class ProductTrackerApp1Application {

	public static void main(String[] args) {
		SpringApplication.run(ProductTrackerApp1Application.class, args);
	}

}
