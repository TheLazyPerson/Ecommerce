package com.bitwise.service;

import java.util.ArrayList;
import java.util.List;

import com.bitwise.domain.Product;

public class CartManager {
	private List<Product> cartProducts;
	public CartManager(){
		cartProducts = new ArrayList<Product>();
	}
	public List<Product> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(List<Product> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	public int addItemToCart(int pid, Product product){
		cartProducts.add(product);
		
		return cartProducts.size();
		
	}
}
