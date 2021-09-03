package com.guilhermeamorim.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.guilhermeamorim.exceptions.AuthenticationErrorExceptions;
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
		
		Optional<User> user = userRepository.findByEmail(email);
		
		if (!user.isPresent()) {
			
			throw new AuthenticationErrorExceptions("User not found for the email entered");
			
		}
		
		if (!user.get().getPassword().equals(password)) {
			
			throw new AuthenticationErrorExceptions("Invalid password");
			
		}
		
		return user.get();
		
	}

	@Override
	@Transactional
	public User saveUser(User user) {
		
		emailValidation(user.getEmail());
		
		return userRepository.save(user);
		
	}

	@Override
	public void emailValidation(String email) {
		
		boolean exist = userRepository.existsByEmail(email);

		if (exist) {
			
			throw new BusinessRulesExceptions("There is already a registered user with this email.");
			
		}
		
	}

}
