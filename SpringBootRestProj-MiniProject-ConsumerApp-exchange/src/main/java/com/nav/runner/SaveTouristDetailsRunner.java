package com.nav.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class SaveTouristDetailsRunner implements CommandLineRunner{
	
	@Autowired RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		String serviceUrl= "http://localhost:4036/tourist/register";
		//prepare json body
		String json_body = "{\"name\":\"Satish\", \"city\":\"Hyderabad\", \"packageType\":\"Gold\", \"budget\":40000.0}";
		//http header
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		//prepare HttpEntity obj having header body
		HttpEntity<String> entity = new HttpEntity<String>(json_body, headers);
		
		//use postForEntity method
//		ResponseEntity<String> res = template.postForEntity(serviceUrl, entity, String.class);
		//using exchange() method
		ResponseEntity<String> res = template.exchange(serviceUrl, HttpMethod.POST, entity, String.class);
		System.out.println("------------------------------------------------------------------------");
		System.out.println("Response Body(result):: "+res.getBody());
		System.out.println("Rsponse Header::"+res.getHeaders());
		System.out.println("Response Status value::"+res.getStatusCode().value());
	}

}
