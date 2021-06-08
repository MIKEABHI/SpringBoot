package com.spring.studentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.studentService.model.Result;

public interface ResultRepo extends JpaRepository<Result, Integer> {

	public Result findByRid(int rid);
}
