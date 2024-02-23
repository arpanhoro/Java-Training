package com.springdemo.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Hello {
	
	@PostMapping("/hello")
	public String display(@RequestBody String name) {
		return "Hello " + name;
	}
}
