package com.bitwise.authentication;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class LoginValidator implements Validator {
	
	@Override
	public boolean supports(Class<?> temp) {
		return User.class.isAssignableFrom(temp);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		User login = (User) obj;
		if (login.getUsername() == null || login.getUsername().length() == 0) {
		
			errors.rejectValue("username", "error.empty.field", "Please Enter User Name");
		} 
		if (login.getPassword() == null || login.getPassword().length() == 0) {
			errors.rejectValue("password", "error.empty.field", "Please Enter Password");
		} 
	}

}
