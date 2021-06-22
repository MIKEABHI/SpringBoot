package com.spring.studentService.annotations;

import java.util.List;

import org.apache.log4j.Logger;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.spring.studentService.controller.MyController;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.DepartmentRepo;
import com.spring.studentService.repository.StudentRepo;

@Component
@Aspect
public class AspectCount {

	private static final Logger logger = Logger.getLogger(MyController.class) ;
	@Autowired StudentRepo sRepo;
	@Autowired DepartmentRepo dRepo;
	List<Student> stCount ;


	@After("@annotation(com.spring.studentService.annotations.StudentCount) && execution(* com.spring.studentService.*.*.*(..))")
	public ResponseEntity<?> anno()  {

		stCount = sRepo.findAll();

		int civil = sRepo.studentDepartment("CIVIL").size();
		int cse = sRepo.studentDepartment("CSE").size();
		int ece = sRepo.studentDepartment("ECE").size();
		int eee = sRepo.studentDepartment("EEE").size();
		int mech = sRepo.studentDepartment("MECH").size();
		int chem = sRepo.studentDepartment("CHEMICAL").size();
		int metal = sRepo.studentDepartment("METALLURGY").size();

		logger.debug("THE TOTAL STUDENTS ENROLLED : "+stCount.size()+""
				+ "\n  STUDENTS IN EACH DEPARTMENT ::"
				+ " CIVIL : "+civil+"  EEE : "+eee+"  MECH :"+mech+"  ECE : "+ece
				+"  CSE :"+cse+"  METALLURGY :"+metal+"  CHEMICAL :"+chem);
		String msg = "THE TOTAL STUDENTS ENROLLED : "+stCount.size();
		return new ResponseEntity<String>(msg,HttpStatus.OK);

	}




}
