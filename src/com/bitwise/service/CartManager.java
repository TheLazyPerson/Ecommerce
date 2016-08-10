package com.bitwise.service;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import com.bitwise.domain.Product;

public class CartManager {
	private Map<Integer, Product> cartProducts;
	public CartManager(Map<Integer,Product> cartProducts){
		this.cartProducts = cartProducts;
	}
	public Map<Integer, Product> getCartProducts() {
		return cartProducts;
	}

	public void setCartProducts(Map<Integer, Product> cartProducts) {
		this.cartProducts = cartProducts;
	}
	
	public int addItemToCart(int pid, Product product){
		cartProducts.put(cartProducts.size() + 1,product);
		
		return cartProducts.size();
		
	}
	public int removeItemToCart(int pid){
		Product product = cartProducts.get(pid);
		if (product != null) {
			cartProducts.remove(pid);
		}
		return cartProducts.size();
		
	}
	public int getCartSize() {
		
		return cartProducts.size();
	}
	public Integer calculatePrice(){
		Integer total = 0;
		for (int i = 1; i < (cartProducts.size() + 1); i++) {
			total += cartProducts.get(i).getPrice();
		}
		return total;
	}
}
