package com.nav.runner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ActorServiceConsumingRunner implements CommandLineRunner{

	@Override
	public void run(String... args) throws Exception {
		RestTemplate rt = new RestTemplate();
		String url = "http://localhost:8080/actor/wish";
		ResponseEntity<String> response = rt.getForEntity(url, String.class); //response with body, header, status code etc
		String result = rt.getForObject(url, String.class); //return object that contain only request body
		System.out.println("Result:: "+result);
	    System.out.println("Response Body(Output):: "+response.getBody());
	    System.out.println("Response Status code value:: "+response.getStatusCodeValue());	    
	    System.out.println("Response status code:: "+response.getStatusCode().getClass());	    
		
	}

}
