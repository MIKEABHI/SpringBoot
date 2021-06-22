package com.spring.studentService;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class StudentServiceApplication {

	private static Logger logger = Logger.getLogger(StudentServiceApplication.class);
//	
//	@GetMapping("/")
//	public String message(Principal principal) {
//		return "Hi "+principal.getName()+" welcome tOo StudentPortal";
//	}

	
	public static void main(String[] args) {
		
		SpringApplication.run(StudentServiceApplication.class, args);
		
		logger.info("---**************************************---\n\n\t\t\t\t\t\tWELCOME TO STUDENT SERVICES APPLICATION ");
		logger.debug("\t ---***APLICATION STARTED***--- \t");
	}

}
