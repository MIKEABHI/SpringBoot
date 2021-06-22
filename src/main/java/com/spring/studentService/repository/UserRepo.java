package com.spring.studentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.studentService.model.User;

public interface UserRepo extends JpaRepository<User, Integer> {

	public User findByUsername(String username);
}
