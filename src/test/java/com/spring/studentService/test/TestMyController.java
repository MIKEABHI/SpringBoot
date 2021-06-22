package com.spring.studentService.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.spring.studentService.exception.MyException;
import com.spring.studentService.model.Department;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.DepartmentRepo;
import com.spring.studentService.repository.StudentRepo;
import com.spring.studentService.service.MyService;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TestMyController {
	
	@Autowired MyService service;
	
	@MockBean StudentRepo sRepo;
	@MockBean DepartmentRepo dRepo;
	
	List<Department> list = new ArrayList<>();
	Student data ;
//	List<Student> data =  new ArrayList<>();
	
//SETUP METHOD	
	@BeforeEach
	public void setUp() {
		//STUDENT BY ID
		data = new Student(1,"MIKE","ABHI","2021");
	
		//LIST OF DEPARTMENT
		list.add(new Department(1, "ECE", "ANITHA"));
		list.add(new Department(2, "CSE", "SRIDEVI"));	
	
		
		
	}
	
//TEST STUDENT BY ID ----ALL DETAILS	
	@Test
	public void MyTest() throws MyException {

		when(sRepo.findBySid(1)).thenReturn(data);
		assertEquals(data, service.student(1));	
	}
	
//TEST DEPARTMENT LIST 	
	@Test
	public void testDep() {
		
		when(dRepo.findAll()).thenReturn(list);
		assertEquals(list, service.getdepartment());	
	}
	
	
	
	
}


