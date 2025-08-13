package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class SpringBootRestProj07AdminServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProj07AdminServerApplication.class, args);
	}

}
