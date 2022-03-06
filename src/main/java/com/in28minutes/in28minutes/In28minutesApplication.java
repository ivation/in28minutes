package com.in28minutes.in28minutes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@SpringBootApplication
public class In28minutesApplication {

	public static void main(String[] args) {
		SpringApplication.run(In28minutesApplication.class, args);
	}

	@GetMapping("/say-hello")
	public String hello() {
		return "Success";
	}

}
