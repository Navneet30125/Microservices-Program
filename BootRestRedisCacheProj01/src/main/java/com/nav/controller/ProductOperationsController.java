package com.nav.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nav.entity.Product;
import com.nav.service.IProductMgmtService;

@RestController
@RequestMapping("/product-api")
public class ProductOperationsController {
	
	@Autowired
	private IProductMgmtService prodService;
	
	@PostMapping("/save")
	public ResponseEntity<String> saveProduct(@RequestBody Product prod){
		Product saveProduct = prodService.addProduct(prod);
		return new ResponseEntity<String>(saveProduct.toString()+" si saved", HttpStatus.CREATED);
	}
	
	@GetMapping("/find/{pid}")
	public ResponseEntity<Product> showAllProduct(@PathVariable int pid){
		Product  prod = prodService.findProductById(pid);
		return new ResponseEntity<Product>(prod, HttpStatus.OK);
	}
	
	@GetMapping("/report")
	public ResponseEntity<List<Product>> showAllProducts(){
		List<Product>  list = prodService.showAllProducts();
		return new ResponseEntity<List<Product>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/delete/{pid}")
	public ResponseEntity<String> deleteProduct(@PathVariable Integer pid){
		String msg = prodService.deleteProduct(pid);
		return new ResponseEntity<String>(msg, HttpStatus.OK);
	}
 }
