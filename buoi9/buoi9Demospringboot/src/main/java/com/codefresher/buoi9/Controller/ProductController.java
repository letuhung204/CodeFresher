package com.codefresher.buoi9.Controller;

import java.rmi.NotBoundException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codefresher.buoi9.model.Product;
import com.codefresher.buoi9.service.ProductManager;

@RestController
public class ProductController {

	
	ProductManager productManager;
	
	/*
	 * dday la 1 api
	 * phan duoi cua mot url /listProduct (request)
	 * fuction thuc hien nhiem vu khi co request map voi end url
	 * lay ra all product
	 * */
			
	@GetMapping("/listProduct")
	public List<Product> getAllProduct(){
		
		productManager = new ProductManager();
		
		//goi den  taafng service
		
		return productManager.init();
	}
	
	/*viet api get product theo ID
	 * param: ID
	 * endpoint: /product
	 * */
	
	@GetMapping("/product")
	public Product getProductById(@RequestParam("id") int id)  {
		productManager = new ProductManager();
		productManager.init();
		
		Product productResult =productManager.getProductById(id);
	
		return productResult;
		 
	}
	
	/*
	 * viet API cho ham update data
	 * param: id, tenmoi,nhasanxuatmoi,ngaysanxuatmoi
	 * method: put
	 * */
	@PutMapping("/update/product")
	public Product updateProduct(@RequestParam("id") int id,@RequestBody Product product) {
		
		productManager = new ProductManager();
		productManager.init();
		
		return productManager.updateProduct(id, product);
	}
	
}
