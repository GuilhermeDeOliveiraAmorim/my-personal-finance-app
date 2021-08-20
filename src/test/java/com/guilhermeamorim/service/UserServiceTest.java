package com.guilhermeamorim.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.guilhermeamorim.exceptions.BusinessRulesExceptions;
import com.guilhermeamorim.model.entity.User;
import com.guilhermeamorim.model.repository.UserRepository;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void mustValidateTheEmail() {
	
		Assertions.assertDoesNotThrow(() -> {
			
			//Scenario
			
			userRepository.deleteAll();
			
			
			//Execution
			
			userService.emailValidation("guilhermeamorim@gmail.com");

			
			//Verification
			
		});

	}
	
	@Test
	public void shouldThrowErrorWhenThereIsRegisteredEmail() {
	
		Assertions.assertThrows(BusinessRulesExceptions.class, () -> {
			
			//Scenario

			User user = User.builder().name("Guilherme Amorim").email("guilhermeamorim@gmail.com").build();
			
			userRepository.save(user);
			
			
			//Execution
			
			userService.emailValidation("guilhermeamorim@gmail.com");

			
			//Verification
			
		});

	}

}
