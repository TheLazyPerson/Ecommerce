package com.bitwise.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bitwise.service.CartManager;
import com.bitwise.service.ProductManager;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	ProductManager productManager;
	@Autowired
	CartManager cartManager;
	
	@RequestMapping (value = "/add", method = RequestMethod.GET)
	public @ResponseBody String addItem (ModelMap model, 
			HttpServletRequest req, HttpServletResponse res,
			@RequestParam Integer id) {
		System.out.println(productManager.findProduct(id));
		int cartSize = cartManager.addItemToCart(id, 
				productManager.findProduct(id));
		String response = ""+cartSize;
		return response;
	}

}
