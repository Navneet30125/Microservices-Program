package com.nav.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UpdateTouristRenumerationByIdRunner implements CommandLineRunner {
	
	@Autowired RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
	String serviceUrl = "http://localhost:4036/tourist/updateBudget/{tid}/{hikePercentage}";
	template.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
	
//	String result = template.patchForObject(serviceUrl, null, String.class, 1, 10);
	ResponseEntity<String> res = template.exchange(serviceUrl, HttpMethod.PATCH, null, String.class, 1, 10);
	System.out.println("Response Body(result)::"+res.getBody());
	
	}

}
