package com.nav.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class UpdateTouristRunner implements CommandLineRunner{
	
	@Autowired RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		String serviceUrl= "http://localhost:4036/tourist/update";
		//prepare json body
		String json_body = "{\"id\":1,\"name\":\"Ravi\", \"city\":\"San-Fransisco\", \"packageType\":\"Gold\", \"budget\":4000000.0}";
		//http header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare HttpEntity obj having header body
		HttpEntity<String> entity = new HttpEntity<String>(json_body, headers);
		
		//update the tourist details
		template.put(serviceUrl, entity);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Tourist updated..........");
	}

}
