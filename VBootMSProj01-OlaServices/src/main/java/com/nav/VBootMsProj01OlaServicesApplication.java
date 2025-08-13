package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class VBootMsProj01OlaServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(VBootMsProj01OlaServicesApplication.class, args);
	}

}
