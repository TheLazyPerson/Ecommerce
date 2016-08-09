package com.bitwise.service;

import java.util.List;
import com.bitwise.domain.Product;

public interface ProductManager {
	public List<Product> getProducts();
	public Product findProduct(int pid);
}
