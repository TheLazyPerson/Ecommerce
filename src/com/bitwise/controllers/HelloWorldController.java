package com.bitwise.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HelloWorldController {
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String printHello(ModelMap model) {
	      model.addAttribute("message", "Hello, World!");
	      return "index";
	}
	
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String printLoginPage(ModelMap model) {
	      model.addAttribute("message", "Hello, World!");
	      return "login";
	}
	
}
