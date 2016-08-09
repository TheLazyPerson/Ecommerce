package com.bitwise.web;

import javax.servlet.http.Cookie;
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

import com.bitwise.authentication.LoginValidator;
import com.bitwise.authentication.User;
import com.bitwise.service.UserManager;

@Controller
public class LoginController {
	@Autowired
	UserManager userManager;
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String printLoginPage(ModelMap model) {
		
		User user = new User ();
		model.addAttribute("title", "Login");
		model.addAttribute("user", user);
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String onSubmit(ModelMap model, @ModelAttribute("user") User user, BindingResult result, HttpSession session,
			HttpServletRequest request, HttpServletResponse response) {
		String url = "login";
		url = handleUserInput(model, user, result, url, request, response);
		return (url);

	}
	
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String onLogout(ModelMap model, HttpSession session,HttpServletRequest request, HttpServletResponse response) {
		if (invalidateSession(request)) {
			return "login";
		}else{
			throw new RuntimeException();
		}
		
		

	}

	private boolean invalidateSession(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		session.invalidate();
		session = request.getSession(false);
		return session == null;
	}

	private String handleUserInput(ModelMap model, User user, BindingResult result, String url,
			HttpServletRequest request, HttpServletResponse response) {
		LoginValidator validator = new LoginValidator();
		validator.validate(user, result);
		url = authenticateUser(model, user, result, url, request, response);
		return url;
	}

	private String authenticateUser(ModelMap model, User user, BindingResult result, String url,
			HttpServletRequest request, HttpServletResponse response) {
		
		if (result.hasErrors()) {
			model.addAttribute("user", user);
			url = "login";
		} else if (this.userManager.getUsers().contains(user)) {
			url = "redirect:/home";
			startSession(user, request, response);
		} else {
			model.addAttribute("error", "invalidUser");
		}
		return url;
	}
	
	private void startSession(User user, HttpServletRequest request, HttpServletResponse response) {
		HttpSession session = request.getSession(true);
		
		session.setAttribute("username", user.getUsername());
		session.setAttribute("sessID", session.getId());
		session.setMaxInactiveInterval(1000);
		Cookie cookie = new Cookie("sessID", session.getId());
		cookie.setMaxAge(10000);
		response.addCookie(cookie);
	}
}
