package com.spring.studentService.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.spring.studentService.annotations.ExeceutionTime;
import com.spring.studentService.annotations.StudentCount;
import com.spring.studentService.exception.MyException;
import com.spring.studentService.helper.DepartmentHelper;
import com.spring.studentService.helper.ResultHelper;
import com.spring.studentService.helper.SportHelper;
import com.spring.studentService.helper.StudentHelper;
import com.spring.studentService.model.Department;
import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.model.User;
import com.spring.studentService.repository.DepartmentRepo;
import com.spring.studentService.repository.DepartmentTemplate;
import com.spring.studentService.repository.ResultRepo;
import com.spring.studentService.repository.SportRepo;
import com.spring.studentService.repository.StudentRepo;
import com.spring.studentService.repository.UserRepo;

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
	@Autowired      StudentHelper sHelper;
	@Autowired  	ResultHelper rHelper;
	@Autowired      DepartmentHelper dHelper;
	@Autowired      SportHelper sportHelper;
	@Autowired      DepartmentTemplate dTemplate;
	@Autowired      UserRepo uRepo;


	/*-----*****SERVICE METHODS AVAILABLE HERE*****-----*/

	//***********************************************************************************************************************************	
	/*GET MAPPING METHODS*/	


	//DISPLAY STUDENT DATABASE BY PAGING & SORTING 	
	public List<Student> getAllEmployees(Integer pageNo, Integer pageSize, String sortBy)  {

		Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

		Page<Student> pagedResult = sRepo.findAll(paging);

		if(pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<Student>(); }  }


	@ExeceutionTime
	@StudentCount
	//MAIN STUDENT SERVICE TO DISPLAY STUDENT DATABASE 	
	public List<Student> getstudent(){
		return sRepo.findAll();  }	


	@ExeceutionTime
	@StudentCount
	//STUDENT BY ID SERVICE-----ALL DETAILS
	public Student student(int id) throws MyException {

		if (id<=0) {
			logger.error("ID CANNOT BE EMPTY");}
		if (sRepo.existsById(id)) {
			Student chObjects = sRepo.findBySid(id);
			return  chObjects;
		} 
		else {
			logger.error(" ID :"+id+" IS NOT FOUND TRY ANOTHER");
			throw new MyException("ID :"+id+" IS NOT FOUND TRY ANOTHER");
		}
	}	


	@ExeceutionTime
	@StudentCount
	//STUDENT BY ID SERVICE	----STUDENT & FINAL RESULT
	public Object[] studentRes(int id)throws MyException{
		if (id<=0) {
			logger.error("ID CANNOT BE EMPTY");
			throw new MyException("ID CANNOT BE '0' OR EMPTY");
		}
		if (sRepo.existsById(id)) {
			Object[] chObjects = sRepo.studentResult(id);

			return  chObjects;
		} 
		else {
			logger.error("ID :"+id+" IS NOT FOUND TRY ANOTHER");
			throw new MyException("ID :"+id+" IS NOT FOUND TRY ANOTHER");
		}
	}	


	@ExeceutionTime
	//STUDENT BY DEPARTMENT SERVICE	---STUDENT & FINAL RESULT	
	public List<Object[]> studentDep(String dname) throws MyException{

		List<Object[]> chObjects = sRepo.studentDepartment(dname);
		if (chObjects.isEmpty()) {
			logger.error("DEPARTNAME :"+dname+"  IS NOT FOUND TRY ANOTHER ");
			logger.info("AVAILABLE DEPARTMENT NAMES ARE \n"
					+ "\t\t\t\t\t\tCIVIL  EEE  MECH  ECE  CSE  CHEMICAL  METALLURGY");
			throw new MyException("DEPARTNAME :"+dname+"  IS NOT FOUND TRY VALID NAME ");
		}
		return chObjects ;  }


	@ExeceutionTime
	//STUDENTS BY SPORT NAME SERVICE ---STUDENT & DEPARTMENT & SPORT
	public List<Object[]> stuSport(String sport){
		return sRepo.studentSport(sport); }


	@ExeceutionTime
	//STUDENTS RESULT ABOVE MARK SERVICE ---STUDENT & DEPARTMENT & FINAL RESULT
	public List<Object[]> resAbove(float mark){
		return sRepo.resultAbove(mark);  }

	@ExeceutionTime
	//STUDENTS RESULT BELOW MARK SERVICE ---STUDENT & DEPARTMENT & FINAL RESULT
	public List<Object[]> resBelow(float mark){
		return sRepo.resultBelow(mark);  }

	@ExeceutionTime
	//STUDENTS RESULT BETWEEN THE MARK SERVICE ---STUDENT & DEPARTMENT & FINAL RESULT
	public List<Object[]> resBetween(float mark1, float mark2){
		return sRepo.resultBetween(mark1, mark2);  }


	@ExeceutionTime
	/*JDBC TEMPLATE SERVICE*/
	//JDBC TEMPLATE SERVICE ---TO DISPLAY DEPARTMENT 
	public List<Department> displaydep(){
		return dTemplate.displayDepartment();	}	


	@ExeceutionTime
	//SERVICE TO DISPLAY DEPARTMENT LIST
	public List<Department> getdepartment(){
		for (Department department : dRepo.findAll()) {
			System.out.println("HI DEPARTMENT  "+department.toString());
		}
		return dRepo.findAll();  }			


	@ExeceutionTime
	//SERVICE TO DISPLAY SPORT LIST	
	public List<Sport> postsport(List<Sport> data) {
		return sportRepo.saveAll(data);  }	


	//***********************************************************************************************************************************
	/*POST MAPPING METHODS*/


	@ExeceutionTime
	//MAIN STUDENT SERVICE TO ENROLL STUDENT 
	public List<Student> poststudent(List<Student> data) {
		data =	rHelper.helpResult(data);//TOTAL CALCULATE
		data= dHelper.helpDepartment(data);//DEPARTMENT GROUPING
		data= sportHelper.helpSport(data);//SPORT GROUPING
		return sRepo.saveAll(data);  }


	@ExeceutionTime
	//SERVICE TO ENROLL DEPARTMENT LIST	
	public List<Department> postdepartment(List<Department> data) throws MyException {

		if (data.isEmpty()) {
			logger.debug("DATA ENTERED CAN'T BE EMPTY");
			throw new MyException("DATA ENTERED CAN'T BE EMPTY");
		}
		Department available = dHelper.checkDepartments(data);
		if (available!=null) {
			logger.debug("IN THE DEPARTMENT SERVICE  "+available.getDname());
			throw new MyException("DEPARTMENT : "+ available.getDname() +" ALREADY AVAILABLE");
		}
		else {
			return dRepo.saveAll(data); }
	}	


	@ExeceutionTime
	//SERVICE TO ENROLL SPORTS LIST
	public List<Sport> getsport(){

		return sportRepo.findAll();
	}	
	
	
	public User registerUser(User data) {
		return uRepo.save(data);
		
	}


	//***********************************************************************************************************************************	
	/*PUT MAPPING METHODS*/	


	@ExeceutionTime
	//MAIN STUDENT SERVICE TO UPDATE STUDENT BY ID	
	public Student updateStudent(Student data ) {

		data=sHelper.checkStudent(data);
		if (data!=null) {
			return sRepo.save(data);
		}
		return null;		
	}


	/*DELETE MAPPING METHODS*/	


	@ExeceutionTime
	//DELETE STUDENT BY ID SERVICE		
	public String delStudent(int id) throws MyException {

		if (sRepo.existsById(id)) {
			sRepo.deleteById(id);
			return "SUCESSFULLY DELETED STUDENT OF ID : "+ id ;
		}
		else {
			throw new MyException("ID :"+id+" IS NOT FOUND CAN'T DELETE");
		}

	}		


	@ExeceutionTime
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


	//***********************************************************************************************************************************	
}
