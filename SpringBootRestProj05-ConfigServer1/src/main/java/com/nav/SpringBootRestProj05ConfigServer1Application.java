package com.nav;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class SpringBootRestProj05ConfigServer1Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRestProj05ConfigServer1Application.class, args);
	}

}
