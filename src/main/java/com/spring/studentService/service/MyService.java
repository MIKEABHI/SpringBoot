package com.spring.studentService.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.studentService.model.Department;
import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.DepartmentRepo;
import com.spring.studentService.repository.ResultRepo;
import com.spring.studentService.repository.SportRepo;
import com.spring.studentService.repository.StudentRepo;
//service class
@Service
public class MyService {

	@Autowired
	StudentRepo sRepo;
	@Autowired
	ResultRepo rRepo;
	@Autowired
	DepartmentRepo dRepo;
	@Autowired
	SportRepo sportRepo;
	
	//MAIN STUDENT SERVICE
	public List<Student> poststudent(List<Student> data) {
		
		return sRepo.saveAll(data);
	}
	public List<Student> getstudent(){
		return sRepo.findAll();
	}
	
	
	
	//DEPARTMENTS MAPPING
	public List<Department> getdepartment(){
		return dRepo.findAll();
	}
	public List<Department> postdepartment(List<Department> data) {
		
		return dRepo.saveAll(data);
	}
	
	//SPORTS MAPPING
	public List<Sport> getsport(){
		return sportRepo.findAll();
	}
	@PostMapping("/postsport")
	public List<Sport> postsport(List<Sport> data) {
		
		return sportRepo.saveAll(data);
}
}
