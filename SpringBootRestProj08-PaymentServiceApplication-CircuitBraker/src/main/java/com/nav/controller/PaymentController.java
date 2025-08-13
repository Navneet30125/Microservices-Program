package com.nav.controller;

import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PaymentController {

    @GetMapping("/pay")
    public String pay() {
        if (new Random().nextBoolean()) {
            throw new RuntimeException("Payment service failed");
        }
        return "Payment successful";
    }
}
