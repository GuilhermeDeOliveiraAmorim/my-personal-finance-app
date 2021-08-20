package com.guilhermeamorim.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.guilhermeamorim.model.entity.User;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Test
	public void checkTheExistenceOfAnEmailInTheDatabase() {
		
		//Scenario
		
		User user = User.builder().name("Guilherme Amorim").email("guilhermeamorim@gmail.com").build();
		
		userRepository.save(user);
		
		//Execution
	
		boolean result = userRepository.existsByEmail("guilhermeamorim@gmail.com");

		//Verification
		
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void shouldReturnFalseWhenThereIsNoUserRegisteredWithTheEmail() {
		
		//Scenario
		
		userRepository.deleteAll();
		
		//Execution
		
		boolean result = userRepository.existsByEmail("guilhermeamorim@gmail.com");
		
		//Verification
		
		Assertions.assertThat(result).isFalse();
		
	}

}
