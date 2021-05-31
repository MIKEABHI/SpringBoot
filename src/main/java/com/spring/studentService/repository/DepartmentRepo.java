package com.spring.studentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.studentService.model.Department;

public interface DepartmentRepo  extends JpaRepository<Department, Integer>{

}
