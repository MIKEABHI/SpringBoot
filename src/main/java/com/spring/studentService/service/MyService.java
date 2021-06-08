package com.spring.studentService.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

import com.spring.studentService.exception.MyException;
import com.spring.studentService.helper.DepartmentHelper;
import com.spring.studentService.helper.ResultHelper;
import com.spring.studentService.helper.SportHelper;
import com.spring.studentService.model.Department;
import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.DepartmentRepo;
import com.spring.studentService.repository.DepartmentTemplate;
import com.spring.studentService.repository.ResultRepo;
import com.spring.studentService.repository.SportRepo;
import com.spring.studentService.repository.StudentRepo;

//SERVICE CLASS
@Service
public class MyService {
//LOGGER CLASS TO MY SERVICE
	private static final Logger logger = Logger.getLogger(MyService.class) ;
//DEPENDENCY INJECTIONS		
	@Autowired      StudentRepo sRepo;
	@Autowired      ResultRepo rRepo;
	@Autowired      DepartmentRepo dRepo;
	@Autowired      SportRepo sportRepo;
	@Autowired  	ResultHelper rHelper;
	@Autowired      DepartmentHelper dHelper;
	@Autowired      SportHelper sportHelper;
	@Autowired      DepartmentTemplate dTemplate;
	
    	
//	-----*****SERVICE METHODS AVAILABLE HERE*****-----
	
	
//*****************************************************************************************		
	
	
//WELCOME MESSAGE SERVICE	
	public String Welcome() {
		String welcome ="\t---***WELCOME TO STUDENT SERVICE PORTAL***---\t\n"
				+ "\n1)ENROLL STUDENTS : service/enrollstudents \n2)SHOW STUDENT DATABASE : service/studentdatabase"
				+ "\n3)STUDENTS BY DEPARTMENT : service/department \n4)STUDENT BY ID : service/student"
				+ "\n5)ENROLL DEPARTMENTS : service/enrolldepartment \n6)SHOW DEPARTMENTS LIST : service/departmentslist"
				+ "\n7)ENROLL SPORTS : service/enrollsports \n8)SHOW SPORTS LIST : service/sportslist"
				+ "\n9)SHOW RESULT ABOVE MARK : service/result/above \n10)SHOW RESULT BELOW MARK : service/result/below"
				+ "\n11)SHOW RESULT BETWEEN MARKS : service/result/between \n12)SHOW STUDENTS BY SPORT : service/sport";
		return welcome;	  }
	
	
//**********************************************************
	
	
//MAIN STUDENT SERVICE TO ENROLL STUDENT 
	public List<Student> poststudent(List<Student> data) throws MyException {
	 data =	rHelper.helpResult(data);//TOTAL CALCULATE
     data= dHelper.helpDepartment(data);//DEPARTMENT GROUPING
     data= sportHelper.helpSport(data);//SPORT GROUPING
     return sRepo.saveAll(data);  }
//--------------------------------------------------------	
//MAIN STUDENT SERVICE TO DISPLAY STUDENT DATABASE 	
	public List<Student> getstudent(){
		return sRepo.findAll();  }
	
	
//***************************************************************	
	
	
//STUDENT BY ID SERVICE-----ALL DETAILS
	public Student student(int id) {
		
		System.out.println("hi test "+sRepo.findBySid(id).toString());
		return sRepo.findBySid(id);}
	
	
//SERVICE TO DISPLAY DEPARTMENT LIST
	public List<Department> getdepartment(){
		for (Department department : dRepo.findAll()) {
			System.out.println("hi test dep  "+department.toString());
		}
		return dRepo.findAll();  }
//------------------------------------------------------	
//SERVICE TO ENROLL DEPARTMENT LIST	
	public List<Department> postdepartment(List<Department> data) throws MyException {
	logger.debug("IN THE DEPARTMENT SERVICE");
		Department available = dHelper.checkDepartments(data);
		if (available!=null) {
			 logger.debug("IN THE DEPARTMENT SERVICE  "+available.getDname());
			throw new MyException("DEPARTMENT : "+ available.getDname() +" ALREADY AVAILABLE");
		}
		else {
			return dRepo.saveAll(data); }
		}
	
	
//*******************************************************	
	
	
//SERVICE TO ENROLL SPORTS LIST
	public List<Sport> getsport(){
		return sportRepo.findAll();  }
//------------------------------------------------------
//SERVICE TO DISPLAY SPORT LIST	
	@PostMapping("/postsport")
	public List<Sport> postsport(List<Sport> data) {
		return sportRepo.saveAll(data);  }

	
//**************************************************************
	
	
//STUDENT BY ID SERVICE	----STUDENT & FINAL RESULT
	public List<Object[]> studentRes(int id){
		if (id<=0) {
			logger.error("ID CANNOT BE EMPTY");}
	     List<Object[]> chObjects =	sRepo.studentResult(id);
	     if (chObjects.size()==0) {
	    		 logger.error(" ID :"+id+" IS NOT FOUND TRY ANOTHER");
			} 
		return  chObjects;  }
	
	
//********************************************************************		
	
	
//STUDENT BY DEPARTMENT SERVICE	---STUDENT & FINAL RESULT	
	public List<Object[]> studentDep(String dname){
		if (dname.equals("")) {
			logger.error("DEPARTMENT NAME CANNOT BE EMPTY");
			logger.info("AVAILABLE DEPARTMENT NAMES ARE \n"
						+ "\t\t\t\t\t\tCIVIL  EEE  MECH  ECE  CSE  CHEMICAL  METALLURGY");}
		List<Object[]> chObjects = sRepo.studentDepartment(dname);
		if (chObjects.size()==0) {
			logger.error("DEPARTNAME :"+dname+"  IS NOT FOUND TRY ANOTHER ");
			logger.info("AVAILABLE DEPARTMENT NAMES ARE \n"
					+ "\t\t\t\t\t\tCIVIL  EEE  MECH  ECE  CSE  CHEMICAL  METALLURGY");
		}
		return chObjects ;  }
	
	
//*******************************************************************

	
//STUDENTS RESULT ABOVE MARK SERVICE ---STUDENT & DEPARTMENT & FINAL RESULT
	public List<Object[]> resAbove(float mark){
		return sRepo.resultAbove(mark);  }
//---------------------------------------------------------------------------	
//STUDENTS RESULT BELOW MARK SERVICE ---STUDENT & DEPARTMENT & FINAL RESULT
		public List<Object[]> resBelow(float mark){
			return sRepo.resultBelow(mark);  }
//-----------------------------------------------------------------------
//STUDENTS RESULT BETWEEN THE MARK SERVICE ---STUDENT & DEPARTMENT & FINAL RESULT
		public List<Object[]> resBetween(float mark1, float mark2){
			return sRepo.resultBetween(mark1, mark2);  }
	
		
//*******************************************************************************	
		
		
//STUDENTS BY SPORT NAME SERVICE ---STUDENT & DEPARTMENT & SPORT
		public List<Object[]> stuSport(String sport){
			return sRepo.studentSport(sport); }

		
//**********************************************************************
		
		
//JDBC TEMPLATE SERVICE ---TO DISPLAY DEPARTMENT 
		public List<Department> displaydep(){
			return dTemplate.displayDepartment();	}
		
		
//*****************************************************************		
}
