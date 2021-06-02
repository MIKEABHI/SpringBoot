package com.spring.studentService.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studentService.model.Department;
import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.service.MyService;

@RestController
public class MyController {

	private static final Logger logger = Logger.getLogger(MyController.class) ;
	
	@Autowired
	private MyService service;
		
//MAIN STUDENT POSTMAPPING (OWNER)
	@PostMapping("/poststudent")
	public List<Student> postStudent(@RequestBody List<Student> data) {
		logger.info("In the POST student map");
		return service.poststudent(data);
	}
	@GetMapping("/getstudent")
	public List<Student> getStudent(){
		logger.info("In the GET student map");
		return service.getstudent();
	}
	
	
//STUDENT BY ID GETMAPPING	----STUDENT & FINAL RESULT	
		@GetMapping("/getstudent/id")
		@ResponseBody
		public List<Object[]> studentResult(@RequestParam(name = "sid") int id){
			
			return service.studentRes(id);
		}
//STUDENT BY DEPARTMENT GETMAPPING ----STUDENT & FINAL RESULT		
		@GetMapping("/getdepartment/name")
		@ResponseBody
		public List<Object[]> studentDepartment(@RequestParam(name = "dname") String dname){
			System.out.println("in the controller"+ dname);
			return service.studentDep(dname);
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
