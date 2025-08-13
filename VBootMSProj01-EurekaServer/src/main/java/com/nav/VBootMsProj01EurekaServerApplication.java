package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class VBootMsProj01EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(VBootMsProj01EurekaServerApplication.class, args);
	}

}
