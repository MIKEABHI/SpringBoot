package com.spring.studentService.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.studentService.helper.DepartmentHelper;
import com.spring.studentService.helper.ResultHelper;
import com.spring.studentService.helper.SportHelper;
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

	private static final Logger logger = Logger.getLogger(MyService.class) ;
	
	@Autowired
	StudentRepo sRepo;
	@Autowired
	ResultRepo rRepo;
	@Autowired
	DepartmentRepo dRepo;
	@Autowired
	SportRepo sportRepo;
	@Autowired
	ResultHelper rHelper;
	@Autowired
	DepartmentHelper dHelper;
	@Autowired
	SportHelper sportHelper;
	
//STUDENT BY ID SERVICE	----STUDENT & FINAL RESULT
	public List<Object[]> studentRes(int id){
		
		if (id<0) {
			logger.error("ID CANNOT BE EMPTY");}
		
		return sRepo.studentResult(id);
	}
//STUDENT BY DEPARTMENT SERVICE	---STUDENT & FINAL RESULT	
	public List<Object[]> studentDep(String dname){
		
		if (dname.equals(null)) {
			logger.error("DNAME CANNOT BE EMPTY");
		}
		System.out.println("in the service"+dname);
		return sRepo.studentDepartment(dname);
	}
	
	
	
	
	//MAIN STUDENT SERVICE
	public List<Student> poststudent(List<Student> data) {
		
	 data =	rHelper.helpResult(data);
     data= dHelper.helpDepartment(data);
     System.out.println(data.toString()+"in the service");
     data= sportHelper.helpSport(data);
     
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
