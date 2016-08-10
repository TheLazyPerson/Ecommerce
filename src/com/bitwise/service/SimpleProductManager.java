package com.bitwise.service;

import java.util.List;

import com.bitwise.domain.Product;
import com.bitwise.exceptions.ItemNotFoundException;

public class SimpleProductManager implements ProductManager {
	private List<Product> products;
	
	@Override
	public List<Product> getProducts() {	
		return products;
	}
	
	public void setProducts(List<Product> products) {
	      this.products = products;
	}
	
	@Override
	public Product findProduct(int pid){
		for (Product product : products) {
			if (product.getId() == pid) {
				return product;
			}
		}
		throw new ItemNotFoundException();
		
	}
	

}
