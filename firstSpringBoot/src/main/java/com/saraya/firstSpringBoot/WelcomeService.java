package com.saraya.firstSpringBoot;

import org.springframework.stereotype.Component;

@Component
public class WelcomeService {
	
	public String retrieveWelcomeMessage() {
		
		//logic - ----
		return "Good Morning Mister Muhammad Sounkoun Soumare Sarayanguo";
	}
}
