package com.nav.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nav.entity.Product;

public interface IProductRepository extends JpaRepository<Product,Integer>{
	
}
