package com.nav.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ShowTouristByIdRunners implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		String serviceUrl = "http://localhost:4036/tourist/find/{id}";
		// use getForEntity method

		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class, 4);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Response Body::" + response.getBody());
		System.out.println("Response Header::" + response.getHeaders());
		System.out.println("Response Status Code::" + response.getStatusCode());
		System.out.println("Response Status Code Value::" + response.getStatusCodeValue());

		// use getForObject method
//		String result = template.getForObject(serviceUrl, String.class,3);
//		System.out.println(result);

	}
}
