package com.bitwise.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.service.ProductManager;

@Controller
public class ProductsController {

	@Autowired
	private ProductManager productManager;
	
	@RequestMapping(value="/home", method = RequestMethod.GET)
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", this.productManager.getProducts());
		myModel.put("cartSize", ""+request.getSession().getAttribute("cartSize"));
		return new ModelAndView( "home", "model", myModel);
	}
	
	@RequestMapping(value="/product", method = RequestMethod.GET)
	public ModelAndView singleProduct(HttpServletRequest request, HttpServletResponse response,
			@RequestParam Integer id) {
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("product", this.productManager.findProduct(id));
		return new ModelAndView( "product", "model", myModel);
	}
	
	public void setProductManager(ProductManager productManager) {
        this.productManager = productManager;
    }
}
