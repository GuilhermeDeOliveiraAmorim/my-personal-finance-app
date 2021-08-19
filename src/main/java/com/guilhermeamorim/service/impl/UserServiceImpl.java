package com.guilhermeamorim.service.impl;

import com.guilhermeamorim.model.entity.User;
import com.guilhermeamorim.repository.UserRepository;
import com.guilhermeamorim.service.UserService;

public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	public UserServiceImpl(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public User login(String email, String password) {
		return null;
	}

	@Override
	public User saveUser(User user) {
		return null;
	}

	@Override
	public void emailValidation(String email) {
		
	}

}
