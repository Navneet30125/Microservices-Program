package com.nav.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nav.client.IBillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping/api")
public class IBillingServiceRestController {
	@Autowired
	private IBillingServiceRestConsumer consumer;
	
	@GetMapping("/details")
	public String displayShoppingDetails() {
		System.out.println("ShoppingController:: client component class name::"+consumer.getClass());
		return "Pongle shopping for family::"+consumer.fetchBillDetails();
	}
}
