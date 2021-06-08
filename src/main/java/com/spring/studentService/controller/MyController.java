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

import com.spring.studentService.exception.MyException;
import com.spring.studentService.model.Department;
import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.service.MyService;

//CONTROLLER CLASS
@RestController
public class MyController {
	
//LOGGER CLASS FOR MY CONTROLLER
	private static final Logger logger = Logger.getLogger(MyController.class) ;
	
	@Autowired private MyService service;

	
//		-----*****CONTRLLER MAPPINGS AVAILABLE HERE*****-----
	
	
//********************************************************************************************	
	
	
//GETMAPPING :-----WELCOME STUDENTS SERVICE POTAL	
	@GetMapping ("/service")
	public String Welcome() {
	return service.Welcome();  }
	
	
//*********************************************************************	
	
	
//POSTMAPPING :-----STUDENT EROLL INTO DATABASE(OWNER ENTITY)
	@PostMapping("/service/enrollstudents")
	public List<Student> postStudent(@RequestBody List<Student> data) throws MyException {
		logger.info("IN THE  POST STUDENT MAP");
		return service.poststudent(data);  }
//------------------------------------------------------------	
//GETMAPPING :-----DISPLAY STUDENT FROM DATABASE	
	@GetMapping("/service/studentdatabase")
	public List<Student> getStudent(){
		logger.info("IN THE GET STUDENT MAP");
		return service.getstudent();  }
	
	
//***************************************************************************	
	
	
//GETMAPPING :---DISPLAY STUDENT BY ID-----ALL DETAILS
	@GetMapping("/service/studentdatabase/roll")
	@ResponseBody
	public Student studentId(@RequestParam(name = "id") int id) {
		return service.student(id); }
	
	
//GETMAPPING :-----DISPLAY STUDENT BY ID-----STUDENT & FINAL RESULT	
		@GetMapping("/service/student")
		@ResponseBody
		public List<Object[]> studentResult(@RequestParam(name = "id") int id){
			return service.studentRes(id); 	}
	
		
//*************************************************************************
		
		
//GETMAPPING :-----DISPLAY STUDENT BY DEPARTMENT-----STUDENT & FINAL RESULT		
		@GetMapping("/service/department")
		@ResponseBody
		public List<Object[]> studentDepartment(@RequestParam(name = "name") String dname){
			return service.studentDep(dname);	}
		
		
//*******************************************************************		

		
//GETMAPPING :-----DISPLAY DEPARTMENTS LIST
		@GetMapping("/service/departmentslist")
		public List<Department> getdepartment(){
			return service.getdepartment();  }
//----------------------------------------------------
//POSTMAPPING :-----ENROLL DEPARTMENTS LIST		
		@PostMapping("/service/enrolldepartments")
		public List<Department> postdepartment(@RequestBody List<Department> data) throws MyException {
		 return service.postdepartment(data);  }
	
		
//*******************************************************************		
		
		
//GETMAPPING :-----DISPLAY SPORTS LIST
		@GetMapping("/service/sportslist")
		public List<Sport> getsport(){
			return service.getsport();  }
//--------------------------------------------------------------
//POSTMAPPING :-----ENROLL SPORTS LIST		
		@PostMapping("/service/enrollsports")
		public List<Sport> postsport(@RequestBody List<Sport> data) {
			return service.postsport(data); 	}

		
//******************************************************************************	
		
		
//GETMAPPING :STUDENTS RESULTS ABOVE MARK ---STUDENTS & DEPARTMENT & FINAL RESULT	
		@GetMapping("service/result/above")
		@ResponseBody
		public List<Object[]> resAbove(@RequestParam(name = "mark") float mark){
			return service.resAbove(mark);  }
//------------------------------------------------------------------
//GETMAPPING :STUDENTS RESULTS BELOW MARK ---STUDENTS & DEPARTMENT & FINAL RESULT
		@GetMapping("service/result/below")
		@ResponseBody
		public List<Object[]> resBelow(@RequestParam(name = "mark") float mark){
			return service.resBelow(mark);  }
//------------------------------------------------------------------
//GETMAPPING :STUDENTS RESULTS BETWEEN MARK ---STUDENTS & DEPARTMENT & FINAL RESULT
		@GetMapping("service/result/between")
		@ResponseBody
		public List<Object[]> resBelow(@RequestParam(name = "mark1") float mark1 ,@RequestParam(name = "mark2") float mark2){
			return service.resBetween(mark1 , mark2);  }		
	
		
//*******************************************************************
		
		
//GETMAPPING :STUDENTS BY SPORT NAME ---STUDENTS & DEPARTMENT & SPORT
		@GetMapping("/service/sport")
		@ResponseBody
		public List<Object[]> stuSport(@RequestParam(name = "name") String sport){
			return service.stuSport(sport); }
		
//*******************************************************************	
		
		
//GETMAPPING :JDBC TEMPLATE TO DISPLAY DEPARTMENT LIST 		
		@GetMapping("/service/template/department")
		public List<Department> dispLayDepartment(){
			return service.displaydep(); }
		
		
//***************************************************************		
	       	
}
