package com.bitwise.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.domain.Product;
import com.bitwise.exceptions.ItemOutOfStockException;
import com.bitwise.service.CartManager;
import com.bitwise.service.ProductManager;

@Controller
@RequestMapping("/cart")
public class CartController {
	@Autowired
	ProductManager productManager;
	
	CartManager cartManager;
	@RequestMapping (value = "/view", method = RequestMethod.GET)
	public ModelAndView cartView(HttpServletRequest req, HttpServletResponse res){
		cartManager = (CartManager) req.getSession(false).getAttribute("cartList");
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", cartManager.getCartProducts());
		return new ModelAndView( "cart", "model", myModel);
		
	}
	
	
	
	@RequestMapping (value = "/add", method = RequestMethod.GET)
	public @ResponseBody String addItem (ModelMap model, 
			HttpServletRequest req, HttpServletResponse res,
			@RequestParam Integer id) {
		cartManager = (CartManager) req.getSession(false).getAttribute("cartList");
		Product product = productManager.findProduct(id);
		
		if (product.getQuantity() <= 0) {
			throw new ItemOutOfStockException();
		}
		
		int cartSize = cartManager.addItemToCart(id, product);
		req.getSession(false).setAttribute("cartSize", cartSize);
		System.out.println("add:"+cartSize);
		String response = ""+cartSize;
		req.setAttribute("cartList", cartManager);
		return response;
	}
	
	@RequestMapping (value = "/remove", method = RequestMethod.GET)
	public ModelAndView removeItem (ModelMap model, 
			HttpServletRequest req, HttpServletResponse res,
			@RequestParam Integer id) {
		cartManager = (CartManager) req.getSession(false).getAttribute("cartList");
		int cartSize = cartManager.removeItemToCart(id);
		req.getSession(false).setAttribute("cartSize", cartSize);
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", cartManager.getCartProducts());
		myModel.put("cartSize", cartSize);
		System.out.println("remove:"+cartSize);
		return new ModelAndView( "redirect:/cart/view", "model", myModel);
	}
	
	@RequestMapping (value = "/size", method = RequestMethod.GET)
	public @ResponseBody String cartSize(HttpServletRequest req, HttpServletResponse res) {
		cartManager = (CartManager)req.getSession(false).getAttribute("cartList");
		String cartSize = cartManager == null ? ""+0 : "" + cartManager.getCartSize();
		return cartSize;
	}
	
	@RequestMapping (value = "/checkout", method = RequestMethod.GET)
	public ModelAndView checkout (ModelMap model, 
			HttpServletRequest req, HttpServletResponse res) {
		cartManager = (CartManager) req.getSession(false).getAttribute("cartList");
		Integer price = cartManager.calculatePrice();
		Map<String, Object> myModel = new HashMap<String, Object>();
		myModel.put("products", cartManager.getCartProducts());
		myModel.put("total", price);
		
		return new ModelAndView( "checkout", "model", myModel);
	}
	@RequestMapping (value = "/place", method = RequestMethod.GET)
	public String placeOrder (ModelMap model, 
			HttpServletRequest req, HttpServletResponse res) {
		req.getSession(false).setAttribute("cartList", new CartManager(new HashMap<Integer,Product>()) );
		return "place";
	}
}
