package com.softapple.online.doctor.test.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.softapple.online.doctor.common.response.ItemResponse;
import com.softapple.online.doctor.test.model.dto.HelloWorldDTO;
import com.softapple.online.doctor.test.service.HelloWorldService;

@RestController
@RequestMapping("/test")
public class TestController {

	@Autowired
	private HelloWorldService helloWorldService;

	@RequestMapping(value = "/hello", method= RequestMethod.GET)
	public ItemResponse<HelloWorldDTO> provideHelloWorld() {
		return new ItemResponse<>(helloWorldService.provideHelloWorld());
	}
	
	@RequestMapping(value = "/insert", method= RequestMethod.POST)
	public void receiveData(String name, String city) {
		System.out.println(name + " " + city);
	}
}
