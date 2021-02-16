package net.javaguides.springboot.controller;

import org.springframework.web.bind.annotation.RestController;


import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMapping;

@RestController
public class HelloController {
	

	@GetMapping("/")
	public String index() {
	return "Welcome";
	}

}