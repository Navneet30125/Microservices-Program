package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class BootProj01EurekaServerClient1Application {

	public static void main(String[] args) {
		SpringApplication.run(BootProj01EurekaServerClient1Application.class, args);
	}

}
