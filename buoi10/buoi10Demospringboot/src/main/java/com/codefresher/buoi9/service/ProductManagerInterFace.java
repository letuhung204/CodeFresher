package com.codefresher.buoi9.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codefresher.buoi9.model.Product;

public interface ProductManagerInterFace {
	
	public List<Product> init();
	public Product createProduct(Product product);
	public Product getProductById(int id);
	public boolean taoProduct(Product product); 
	
	public Product updateProduct2(Product product,int id);
}
