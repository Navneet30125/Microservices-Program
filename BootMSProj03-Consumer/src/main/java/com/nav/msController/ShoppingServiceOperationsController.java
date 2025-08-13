package com.nav.msController;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nav.client.BillingServiceRestConsumer;

@RestController
@RequestMapping("/shopping")
public class ShoppingServiceOperationsController {
	@Autowired
	private BillingServiceRestConsumer client;
	@GetMapping("/details")
	public ResponseEntity<String> showBillingDetails() {
		String resBody = client.getBillingInfo();
		String billInfo = "Bill Amount::"+new Random().nextInt(100000);
		return new ResponseEntity<String>(billInfo+"....."+resBody, HttpStatus.OK);
	}
}
