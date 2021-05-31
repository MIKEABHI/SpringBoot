package com.spring.studentService.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studentService.model.Department;
import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.DepartmentRepo;
import com.spring.studentService.repository.ResultRepo;
import com.spring.studentService.repository.SportRepo;
import com.spring.studentService.repository.StudentRepo;

@RestController
public class MyController {

	@Autowired
	StudentRepo sRepo;
	@Autowired
	ResultRepo rRepo;
	@Autowired
	DepartmentRepo dRepo;
	@Autowired
	SportRepo sportRepo;
	
	
	@PostMapping("/poststudent")
	public List<Student> poStudent(@RequestBody List<Student> data) {
		
		return sRepo.saveAll(data);
	}
	@GetMapping("/getstudent")
	public List<Student> getStudent(){
		return sRepo.findAll();
	}
	
	
	
	//DEPARTMENTS MAPPING
	@GetMapping("/getdepartment")
	public List<Department> getdepartment(){
		return dRepo.findAll();
	}
	@PostMapping("/postdepartment")
	public List<Department> postdepartment(@RequestBody List<Department> data) {
		
		return dRepo.saveAll(data);
	}
	
	//SPORTS MAPPING
	@GetMapping("/getsport")
	public List<Sport> getsport(){
		return sportRepo.findAll();
	}
	@PostMapping("/postsport")
	public List<Sport> postsport(@RequestBody List<Sport> data) {
		
		return sportRepo.saveAll(data);
}
}
