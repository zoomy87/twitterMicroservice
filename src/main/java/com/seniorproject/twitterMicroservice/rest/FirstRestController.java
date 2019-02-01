package com.seniorproject.twitterMicroservice.rest;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FirstRestController {

	
	@GetMapping("/")
	public String HelloMap() {
		return "Hello World! Time on Server is "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String workout() {
		return "Run a hard 5K!";
	}
	
	@GetMapping("/fortune")
	public String getFortune() {
		return "Today is your lucky Day!!";
	}
}
