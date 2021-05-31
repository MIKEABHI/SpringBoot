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
import com.spring.studentService.service.MyService;

@RestController
public class MyController {

	@Autowired
	private MyService service;
	
	//MAIN STUDENT MAPPING (OWNER)
	@PostMapping("/poststudent")
	public List<Student> postStudent(@RequestBody List<Student> data) {
		
		return service.poststudent(data);
	}
	@GetMapping("/getstudent")
	public List<Student> getStudent(){
		return service.getstudent();
	}
	
	
	
	//DEPARTMENTS MAPPING
	@GetMapping("/getdepartment")
	public List<Department> getdepartment(){
		return service.getdepartment();
	}
	@PostMapping("/postdepartment")
	public List<Department> postdepartment(@RequestBody List<Department> data) {
		
		return service.postdepartment(data);
	}
	
	//SPORTS MAPPING
	@GetMapping("/getsport")
	public List<Sport> getsport(){
		return service.getsport();
	}
	@PostMapping("/postsport")
	public List<Sport> postsport(@RequestBody List<Sport> data) {
		
		return service.postsport(data);
}
}
