package com.spring.studentService.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.spring.studentService.exception.MyException;
import com.spring.studentService.model.Department;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.DepartmentRepo;

@Service
public class DepartmentHelper {

	private static final Logger logger = Logger.getLogger(DepartmentHelper.class) ;
	
	@Autowired   DepartmentRepo dRepo;
	@Autowired   MyException exception;
	
	@ExceptionHandler(value = MyException.class)
	public List<Student> helpDepartment(List<Student> data) {
		
	 for (Student student : data) {
		Department department = student.getDepartment();
		department= dRepo.findByDname(department.getDname());
		if (department!=null) {
			student.setDepartment(department); 
			logger.debug("GROUPING STUDENTS BY DEPARTMENT DETAILS ");
			return data;}
		else {
			logger.error(exception.error("DEPARTMENT IS NOT VALID CHECK BELOW \n\t\t\t\t\t "
					+ "\t\t\tCIVIL EEE MECH ECE CSE MEALLURGY CHEMICAL"));
		//	throw new MyException("DEPARTMENT NAME IS NOT VALID"); 
			}    }
	 
		return data;
	}
	
//CHECK DUPLICATE ENTRY FOR DEPARTMENT	
	public Department checkDepartments(List<Department> data){

		Department chDepartment ;
		logger.debug("IN THE DEPARTMENT HELPER");
		for (Department department : data) {

		 chDepartment = dRepo.findByDname(department.getDname());
		 if (chDepartment!= null) {
			 logger.debug("IN THE DEPARTMENT HELPER  "+chDepartment.getDname());
			return chDepartment;
		}
		}
          return null ;
	}
	
}
