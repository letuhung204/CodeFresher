package com.codefresher.buoi9.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.codefresher.buoi9.model.Product;

@Service
public class ProductManager implements ProductManagerInterFace{
	
	List<Product> lisProducts;
	
	@Override
	public List<Product> init() {
		Product product1 = new Product(1, "san pham 1", "2021-12-05", "toyota");
		Product product2 = new Product(2, "san pham 2", "2021-12-05", "mec");
		Product product3 = new Product(3, "san pham 3", "2021-12-05", "bmw");
		Product product4 = new Product(4, "san pham 4", "2021-12-05", "camry");
		Product product5 = new Product(5, "san pham 5", "2021-12-05", "audi");
		Product product6 = new Product(6, "san pham 6", "2021-12-05", "lambogini");
		Product product7 = new Product(7, "san pham 7", "2021-12-05", "poscher");
		
		lisProducts = new ArrayList<>();
		lisProducts.add(product1);
		lisProducts.add(product2);
		lisProducts.add(product3);
		lisProducts.add(product4);
		lisProducts.add(product5);
		lisProducts.add(product6);
		lisProducts.add(product7);
		
		return lisProducts;
	}
	
	//tao mot product
	@Override
	public Product createProduct(Product product) {
		
		lisProducts.add(product);
		return product;
	}
	//get product by ID
	@Override
	public Product getProductById(int id) {
		
		for(int i=0;i<lisProducts.size();i++) {
			if(id == lisProducts.get(i).getId()) {
				return lisProducts.get(i);
			}
		}
		return null;
	}
	
	@Override
	public boolean taoProduct(Product product) {
		lisProducts = new ArrayList<>();
		init();
		
		if(null == product.getName()) {
			return false;
		}
		lisProducts.add(product);
		System.out.println("list product: ");
		
		for (Product product2 : lisProducts) {
			System.out.println(product2.getName() + " ;" + product2.getNhaSanXuat() +"; "+ product2.getDateCreate());
		}
		
		return true;
	}
	//code update
	@Override
	public Product updateProduct2(Product product,int id) {
		
		lisProducts = new ArrayList<>();
		init();
		// lasy ra thang product ma anh muon update id
		for (int i=0;i<lisProducts.size();i++) {
			if(lisProducts.get(i).getId() == id) {
				lisProducts.get(i).setName(product.getName());
				lisProducts.get(i).setDateCreate(product.getDateCreate());
				lisProducts.get(i).setNhaSanXuat(product.getNhaSanXuat());
				return lisProducts.get(i);
			}
		}
		
		return null;
	} 
	
	
	//update
	public Product updateProduct(int id,Product productNew) {
		//xu ly logic
		//lay product minh muon update
		Product product =lisProducts.get(id);
		if(null != product) {
			product.setId(product.getId());
			product.setName(productNew.getName());
			product.setNhaSanXuat(productNew.getNhaSanXuat());
			product.setDateCreate(productNew.getDateCreate());
		}
		
		return product;
	
	}
	//deleted
	
}
