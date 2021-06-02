package com.spring.studentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.studentService.model.Sport;

public interface SportRepo extends JpaRepository<Sport, Integer> {

	
	public Sport findBySportname(String sportname);
}
