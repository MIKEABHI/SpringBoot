package com.spring.studentService;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentServiceApplication {

	private static Logger logger = Logger.getLogger(StudentServiceApplication.class);
	
	public static void main(String[] args) {
		
	//	Layout layout = new PatternLayout("%d-%C[%M] : {%p}=%m<%L> %n ");
		
	//	Appender appender = new ConsoleAppender(layout);
		
	//	logger.addAppender(appender);
		
		SpringApplication.run(StudentServiceApplication.class, args);
		
		logger.info("---**************************************---\n\n\t\t\t\t\t\tWELCOME TO STUDENT SERVICES APPLICATION ");
		logger.debug("\t ---***APLICATION STARTED***--- \t");
	}

}
