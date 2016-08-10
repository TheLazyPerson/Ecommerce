package com.bitwise.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LogoutController {
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String onLogout(ModelMap model,HttpServletRequest request, HttpServletResponse response) {
		if (invalidateSession(request)) {
			return "redirect:login";
		}else{
			throw new RuntimeException();
		}
	}

	private boolean invalidateSession(HttpServletRequest request) {
		request.getSession(false).invalidate();
		
		
		
		return true;
	}
}
