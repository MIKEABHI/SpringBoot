package com.spring.studentService;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;
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
		
		logger.info("this is in info log ");
		logger.debug("this is debug message");
		logger.fatal("this is in fatal logger");
		logger.warn("this is in warning log");
		logger.error("this is in error log");
	}

}
