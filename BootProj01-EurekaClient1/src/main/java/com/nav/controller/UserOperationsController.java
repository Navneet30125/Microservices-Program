package com.nav.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-api")
public class UserOperationsController {
	
	@RequestMapping("/user")
	public String userMessage() {
		return "Welcome to User";
	}
}
