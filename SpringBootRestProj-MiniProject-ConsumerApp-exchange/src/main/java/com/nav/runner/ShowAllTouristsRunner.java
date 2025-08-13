package com.nav.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.nav.entity.TouristData;

@Component
public class ShowAllTouristsRunner implements CommandLineRunner {

	@Autowired
	private RestTemplate template;

	@Override
	public void run(String... args) throws Exception {
		String serviceUrl = "http://localhost:4036/tourist/findAll";
		System.out.println("------------------------------------------------------------------------");

		// use getForEntity method

//		ResponseEntity<String> response = template.getForEntity(serviceUrl, String.class);
		
		//using exchange() method - this is alternative for all getForObject(), GetXXXObjeact(), This method handle all operations
		ResponseEntity<String> response = template.exchange(serviceUrl, HttpMethod.GET, null, String.class);

		System.out.println("Response Body::" + response.getBody());
		System.out.println("Response Header::" + response.getHeaders());
		System.out.println("Response Status Code::" + response.getStatusCode());
		System.out.println("Response Status Code Value::" + response.getStatusCodeValue());
		
		//convert Json text to model class object using Jackson Api
		ObjectMapper mapper = new ObjectMapper();
		List<TouristData> list = mapper.readValue(response.getBody(), new TypeReference<List<TouristData>>() {});
		System.out.println("Json Object to List<TouristData> obj::");
		list.forEach(System.out::println);
		
		// use getForObject method
//		String result = template.getForObject(serviceUrl, String.class);
//		System.out.println(result);

	}

}
