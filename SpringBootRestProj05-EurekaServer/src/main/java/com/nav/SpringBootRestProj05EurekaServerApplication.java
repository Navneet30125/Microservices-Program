package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class SpringBootRestProj05EurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProj05EurekaServerApplication.class, args);
	}

}
