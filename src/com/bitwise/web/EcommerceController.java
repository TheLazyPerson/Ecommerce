package com.bitwise.web;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.bitwise.authentication.LoginValidator;
import com.bitwise.authentication.User;
import com.bitwise.service.ProductManager;

@Controller
public class EcommerceController {
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello, World!");
	     
	      return "index";
	}
	
	
	
}
