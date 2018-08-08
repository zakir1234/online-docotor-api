package com.softapple.online.doctor.test.service;

import org.springframework.stereotype.Service;

import com.softapple.online.doctor.test.model.dto.HelloWorldDTO;

@Service
public class HelloWorldService {

	
	public HelloWorldDTO provideHelloWorld() {
		HelloWorldDTO helloWorldDTO = new HelloWorldDTO();
		helloWorldDTO.setId(101L);
		helloWorldDTO.setValue("Hello World");
		return helloWorldDTO;		
	}
}
