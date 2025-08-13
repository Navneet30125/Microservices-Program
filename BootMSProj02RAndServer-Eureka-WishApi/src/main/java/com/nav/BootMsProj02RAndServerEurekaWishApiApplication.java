package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootMsProj02RAndServerEurekaWishApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootMsProj02RAndServerEurekaWishApiApplication.class, args);
	}

}
