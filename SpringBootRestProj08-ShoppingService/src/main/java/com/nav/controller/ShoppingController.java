package com.nav.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@RestController
@RequestMapping("/shopping-api")
public class ShoppingController {

    private final RestTemplate restTemplate = new RestTemplate();
    private static final String CB_NAME = "shoppingServiceCB";

    @GetMapping("/purchase")
    @CircuitBreaker(name = CB_NAME, fallbackMethod = "billingFallback")
    public ResponseEntity<String> purchase() {
        String paymentResponse = restTemplate.getForObject("http://localhost:9092/pay", String.class);
        return ResponseEntity.ok("Shopping done: " + paymentResponse);
    }

    public ResponseEntity<String> billingFallback(Exception ex) {
        return ResponseEntity.status(500)
                .body("Billing system down. Please try again later.");
    }
}
