package com.spring.studentService.helper;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.studentService.controller.MyController;
import com.spring.studentService.exception.MyException;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.StudentRepo;
@Service
public class StudentHelper {

	private static final Logger logger = Logger.getLogger(MyController.class) ;
	@Autowired StudentRepo sRepo;
	@Autowired   MyException exception;
	
	public Student checkStudent(Student data)  {
		
		Student existingData = sRepo.findBySid(data.getSid());
		if (data.getSid()==data.getResult().getRid()) {
			
		if (existingData!=null) {
		existingData.setFname(data.getFname());
		System.out.println("updated "+existingData.getFname());
		existingData.setLname(data.getLname());
		existingData.setBatch(data.getBatch());
		if (data.getDepartment()!=null) {
			existingData.setDepartment(data.getDepartment()); 
			}
		if (data.getResult()!=null) {
			existingData.setResult(data.getResult());
		}
		if (data.getSports()!=null) {
			existingData.setSports(data.getSports());
		}
		return existingData;
		}
		else {
		logger.error(exception.error("HEY ID "+data.getSid()+" ENTERED IS NOT FOUND"));

		}
		}else {
			logger.error("HEY BUDDY STUDENT ID & RESULT ID DID'T MATCH ");
		}
	return null;
		
	}
	
	
	
}
