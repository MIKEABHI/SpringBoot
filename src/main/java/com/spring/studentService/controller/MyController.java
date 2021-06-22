package com.spring.studentService.controller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.spring.studentService.exception.MyException;
import com.spring.studentService.model.Department;
import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.model.User;
import com.spring.studentService.service.MyService;

//CONTROLLER CLASS
//@EnableOAuth2Sso
@RestController
public class MyController {

	/*LOGGER CLASS FOR MY CONTROLLER*/
	private static final Logger logger = Logger.getLogger(MyController.class) ;

	@Autowired private MyService service;
	

	@GetMapping("/service/division/{D},{d}")
	public float Div(@PathVariable int D,@PathVariable int d) {
		System.out.println("HI DIVISION METHOD ");
		float res =D/d;
		System.out.println("RESULT =  "+res);
		return res;
	}
	@GetMapping("/service/failed")
	public String failed() {
		return "\n\n\t\t\t\t\tFAILED TO LOGIN !!";
	}
	@GetMapping("/service/logout")
	public String logout() {
		return "\n\n\t\t\t\t\tSUCESSFULLY LOGGED OUT !! ";
	}
	

	/*-----*****CONTRLLER MAPPINGS AVAILABLE HERE*****-----*/

	//***********************************************************************************************************************************
	/*GET MAPPING METHODS*/


	//-----WELCOME STUDENTS SERVICE PORTAL	
	@GetMapping("/service/")
	public String Welcome() {

		return service.Welcome();  
	}


	//-----DISPLAY STUDENT FROM DATABASE BY PAGING & SORTING	
	@GetMapping("/service/studentdatabase/paging")
	public ResponseEntity<List<Student>> getAllEmployees(
			@RequestParam(defaultValue = "0") Integer pageNo, 
			@RequestParam(defaultValue = "5") Integer pageSize,
			@RequestParam(defaultValue = "sid") String sortBy) {

		List<Student> list = service.getAllEmployees(pageNo, pageSize, sortBy);

		return new ResponseEntity<List<Student>>(list, new HttpHeaders(), HttpStatus.OK);  
	}


	//-----DISPLAY STUDENT FROM DATABASE	
	@GetMapping("/service/studentdatabase")
	public List<Student> getStudent(){


		return service.getstudent();
	}

	
	//-----DISPLAY STUDENT BY ID-----ALL DETAILS
	@GetMapping("/service/studentdatabase/roll")
	@ResponseBody
	public Student studentId(@RequestParam(name = "id") int id)throws MyException {

		return service.student(id);
	}


	//-----DISPLAY STUDENT BY ID-----STUDENT & FINAL RESULT	
	@GetMapping("/service/student")
	@ResponseBody
	public Object[] studentResult(@RequestParam(name = "id") int id) throws MyException{

		return service.studentRes(id);
	}	


	//-----DISPLAY STUDENT BY DEPARTMENT-----STUDENT & FINAL RESULT		
	@GetMapping("/service/department")
	@ResponseBody
	public List<Object[]> studentDepartment(@RequestParam(name = "name") String dname) throws MyException{

		return service.studentDep(dname);
	}				


	//-----STUDENTS BY SPORT NAME ---STUDENTS & DEPARTMENT & SPORT
	@GetMapping("/service/sport")
	@ResponseBody
	public List<Object[]> stuSport(@RequestParam(name = "name") String sport){

		return service.stuSport(sport); 
	}			


	//-----STUDENTS RESULTS ABOVE MARK ---STUDENTS & DEPARTMENT & FINAL RESULT	
	@GetMapping("service/result/above")
	@ResponseBody
	public List<Object[]> resAbove(@RequestParam(name = "mark") float mark){

		return service.resAbove(mark);
	}			

	//-----STUDENTS RESULTS BELOW MARK ---STUDENTS & DEPARTMENT & FINAL RESULT
	@GetMapping("service/result/below")
	@ResponseBody
	public List<Object[]> resBelow(@RequestParam(name = "mark") float mark){

		return service.resBelow(mark);
	}			

	//-----STUDENTS RESULTS BETWEEN MARK ---STUDENTS & DEPARTMENT & FINAL RESULT
	@GetMapping("service/result/between")
	@ResponseBody
	public List<Object[]> resBelow(@RequestParam(name = "mark1") float mark1 ,@RequestParam(name = "mark2") float mark2){

		return service.resBetween(mark1 , mark2); 
	}		


	/*JDBC TEMPLATE*/

	//-----JDBC TEMPLATE TO DISPLAY DEPARTMENT LIST 		
	@GetMapping("/service/template/department")
	public List<Department> dispLayDepartment(){

		return service.displaydep();
	}		


	//-----DISPLAY DEPARTMENTS LIST
	@GetMapping("/service/departmentslist")
	public List<Department> getdepartment(){

		return service.getdepartment(); 
	}		


	//-----DISPLAY SPORTS LIST
	@GetMapping("/service/sportslist")
	public List<Sport> getsport(){

		return service.getsport(); 
	}


	//***********************************************************************************************************************************	
	/*POST MAPPING METHODS*/


	//-----STUDENT EROLL INTO DATABASE(OWNER ENTITY)
	@PostMapping("/service/enrollstudents")		 
	public List<Student> postStudent(@RequestBody List<Student> data)  {

		logger.info("IN THE  POST STUDENT MAP");

		return service.poststudent(data);
	}		 		  


	//-----ENROLL DEPARTMENTS LIST		
	@PostMapping("/service/enrolldepartments")
	public List<Department> postdepartment(@RequestBody List<Department> data) throws MyException {

		return service.postdepartment(data);
	}


	//-----ENROLL SPORTS LIST		
	@PostMapping("/service/enrollsports")
	public List<Sport> postsport(@RequestBody List<Sport> data) {

		return service.postsport(data); 
	}

	@PostMapping("/service/user")
	public User register(User data) {
		return service.registerUser(data);	
	}

	//***********************************************************************************************************************************		
	/*PUT MAPPING METHODS*/	


	//-----UPDATE STUDENT DATA BY ID	
	@PutMapping("/service/updatestudent")
	public Student updateStudent(@RequestBody Student data ) {

		return service.updateStudent(data);	
	}			

	/*DELETE MAPPING METHODS*/	


	//-----DELETE STUDENT BY ID
	@DeleteMapping("/service/delete")
	@ResponseBody
	public String deleteStudent(@RequestParam(name = "id") int id) throws MyException {
		return service.delStudent(id);
	}


	//***********************************************************************************************************************************		

}
