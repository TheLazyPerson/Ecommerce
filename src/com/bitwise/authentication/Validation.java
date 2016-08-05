package com.bitwise.authentication;

public class Validation {
	
	public static boolean nullAndEmptyCheck(String param){
		if (param != null || param.isEmpty()) {
			return true;
		}
		return false;
	}
	
	public static boolean isValidEmail(String email){
		if (email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z]{2,6}$")) {
			return true;
		}
		return false;
	}
}
