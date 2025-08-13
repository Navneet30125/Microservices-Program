package com.nav.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class OlaServicesController {

	@GetMapping("/ola")
	public String olaService() {
		return "Welcome to Ola Home Page, How can We help you....";
	}
}
