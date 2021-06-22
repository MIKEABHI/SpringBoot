package com.spring.studentService.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.studentService.model.Department;
@Repository
public interface StudentTemplate {

	public List<Department> displaystudent();
}

