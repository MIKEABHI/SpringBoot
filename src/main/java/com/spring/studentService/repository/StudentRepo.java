package com.spring.studentService.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.studentService.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{

}
