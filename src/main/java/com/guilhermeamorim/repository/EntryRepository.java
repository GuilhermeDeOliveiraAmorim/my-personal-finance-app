package com.guilhermeamorim.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.guilhermeamorim.model.entity.Entry;

public interface EntryRepository extends JpaRepository<Entry, Long> {
	
	

}
