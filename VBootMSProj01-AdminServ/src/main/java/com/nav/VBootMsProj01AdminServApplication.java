package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@SpringBootApplication
@EnableAdminServer
public class VBootMsProj01AdminServApplication {

	public static void main(String[] args) {
		SpringApplication.run(VBootMsProj01AdminServApplication.class, args);
	}

}
