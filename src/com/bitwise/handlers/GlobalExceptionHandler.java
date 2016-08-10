package com.bitwise.handlers;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.domain.Product;
import com.bitwise.exceptions.ItemNotFoundException;
import com.bitwise.exceptions.ItemOutOfStockException;
import com.bitwise.service.CartManager;

@ControllerAdvice
public class GlobalExceptionHandler {

	public static final String DEFAULT_ERROR_VIEW = "error";
	public static final String PAGE_NOT_FOUND_ERROR_VIEW = "404";
	
	
	@ExceptionHandler(value ={ItemOutOfStockException.class})
	public String itemOutOfStock(HttpServletRequest request, Exception e) {
		request.getSession(false).setAttribute("cartList",  new CartManager(new HashMap<Integer,Product>()));
		return "outOfStock";
	}
	
	@ExceptionHandler(value ={ItemNotFoundException.class})
	public ModelAndView itemNotFound(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		return mav;
	}
	
	@ExceptionHandler(value ={Throwable.class, Exception.class, RuntimeException.class})
	public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) {
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW);

		mav.addObject("exception", e);
		mav.addObject("url", request.getRequestURL());
		return mav;
	}

}
