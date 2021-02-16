package net.javaguides.springboot.service;

import org.springframework.stereotype.Component;

@Component
public class HelloServiceImp implements HelloService {

	@Override
	public String hello() {
		
		return "Bienvenue";
	}

	
	
}
