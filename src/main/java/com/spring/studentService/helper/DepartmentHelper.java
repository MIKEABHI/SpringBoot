package com.spring.studentService.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.studentService.model.Department;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.DepartmentRepo;

@Service
public class DepartmentHelper {

	private static final Logger logger = Logger.getLogger(DepartmentHelper.class) ;
	
	@Autowired
	DepartmentRepo dRepo;
	
	public List<Student> helpDepartment(List<Student> data){
		
	 for (Student student : data) {
		Department department = student.getDepartment();
		department= dRepo.findByDname(department.getDname());
		student.setDepartment(department);
	}
	 logger.debug("GROUPING STUDENTS BY DEPARTMENT DETAILS ");
		return data;
	}
	
}
