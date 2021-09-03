package com.guilhermeamorim.model.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.guilhermeamorim.model.entity.User;

@ExtendWith(SpringExtension.class)
@ActiveProfiles("test")
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	TestEntityManager testEntityManager;
	
	@Test
	public void checkTheExistenceOfAnEmailInTheDatabase() {
		
		//Scenario
		
		User user = User.builder().name("Guilherme Amorim").email("guilhermeamorim@gmail.com").build();
		
		testEntityManager.persist(user);
		
		//Execution
	
		boolean result = userRepository.existsByEmail("guilhermeamorim@gmail.com");

		//Verification
		
		Assertions.assertThat(result).isTrue();
		
	}
	
	@Test
	public void shouldReturnFalseWhenThereIsNoUserRegisteredWithTheEmail() {
		
		//Execution
		
		boolean result = userRepository.existsByEmail("guilhermeamorim@gmail.com");
		
		//Verification
		
		Assertions.assertThat(result).isFalse();
		
	}
	
	@Test
	public void mustPersistAUserInTheDatabase() {
		
		//Scenario
		
		User user = User.builder().name("Guilherme Amorim").email("guilhermeamorim@gmail.com").password("ad456ads456").build();
		
		//Execution
		
		User userSaved = userRepository.save(user);
		
		//Verification
		
		Assertions.assertThat(userSaved.getId()).isNotNull();
		
	}

}
