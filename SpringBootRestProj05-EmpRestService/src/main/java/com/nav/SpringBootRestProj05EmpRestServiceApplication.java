package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SpringBootRestProj05EmpRestServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProj05EmpRestServiceApplication.class, args);
	}

}
