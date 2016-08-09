package com.bitwise.service;

import java.util.List;

import com.bitwise.authentication.User;

public class UserManager {
private List<User> users;
	
	public List<User> getUsers() {
		return users;
	}
	
	public void setUsers(List<User> users) {
	      this.users = users;
	}

	
}
