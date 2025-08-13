package com.nav.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductOperationsController {
	@RequestMapping("/product")
public String productOperation() {
	return "Product delivered Succesfully";
}
}
