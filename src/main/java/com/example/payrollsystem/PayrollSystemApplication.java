package com.example.payrollsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class PayrollSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollSystemApplication.class, args);
	}
}