package com.guilhermeamorim.service;

import com.guilhermeamorim.model.entity.User;

public interface UserService {
	
	User login(String email, String password);
	
	User saveUser(User user);
	
	void emailValidation(String email);

}
