package com.guilhermeamorim.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.guilhermeamorim.exceptions.BusinessRulesExceptions;
import com.guilhermeamorim.model.entity.User;
import com.guilhermeamorim.model.repository.UserRepository;
import com.guilhermeamorim.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	private UserRepository userRepository;

	@Autowired
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
		
		boolean exist = userRepository.existsByEmail(email);

		if (exist) {
			
			throw new BusinessRulesExceptions("There is already a registered user with this email.");
			
		}
		
	}

}
