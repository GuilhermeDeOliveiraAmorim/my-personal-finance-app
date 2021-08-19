package com.guilhermeamorim.model.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermeamorim.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	boolean existsByEmail(String email);

}
