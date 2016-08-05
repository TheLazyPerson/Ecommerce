package com.bitwise.authentication;

import java.util.HashMap;
import java.util.Map;

public class UserAuthenticator {
	private Map<String, String> credentials = new HashMap<String, String>();
	
	private void setCredentials(){
		if (credentials.size() == 0) {
			credentials.put("trial@bitwiseglobal.com", "1234");
			credentials.put("harsh@bitwiseglobal.com", "1234");
			credentials.put("pooja@bitwiseglobal.com", "1234");
			credentials.put("taher@bitwiseglobal.com", "1234");
			credentials.put("om@bitwiseglobal.com", "1234");
			credentials.put("akanksha@bitwiseglobal.com", "1234");
		}
	}
	
	public boolean checkLoginCredentials(String username,String password){
		setCredentials();
		if (credentials.get(username).equals(password)) {
			return true;
		}
		return false;
	}
	
	public boolean validateCredentials(String username, String password){
		
		return false;
	}
	
	
}
