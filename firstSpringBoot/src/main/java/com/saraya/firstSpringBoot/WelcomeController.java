package com.saraya.firstSpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
	@Autowired
	WelcomeService service;
	@RequestMapping("/welcome")
	public String welcomeMessage() {
		return "Hey Saraya Guys I hope you having fun";
	}
	
	
	@RequestMapping("/welcomeMessage")
	public String RetrieveWelcomeMsg() {
		return service.retrieveWelcomeMessage();
	}
}
