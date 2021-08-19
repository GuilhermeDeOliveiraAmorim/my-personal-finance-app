package com.guilhermeamorim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermeamorim.model.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
	
	

}
