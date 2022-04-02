package com.example.payrollsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@SpringBootApplication
public class PayrollSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(PayrollSystemApplication.class, args);
	}

	@GetMapping("/hello")
	public HashMap<Integer ,String> greeting() {
		HashMap<Integer, String> map = new HashMap<>();
		map.put(1, "Mustapha");
		map.put(2, "Stevens");
		map.put(3, "Smith");
		map.put(4, "Manaf");
		return map;
	}

}
