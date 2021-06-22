package com.spring.studentService.exception;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class MyException extends Exception {

	private static final long serialVersionUID = 1L;

	private static final Logger logger = Logger.getLogger(MyException.class) ;

	
	public String arith(String msg)throws ArithmeticException{
		return "ARITHMETIC EXCEPTION HANDLED "+ msg;
	}
	
	//CUSTOM EXCEPTION	
	public String error(String msg) {	
	
		return "U GOTCHA ERROR BUDDY!!! "+ msg; 	}
	
	public MyException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public MyException(String message) {
		super(message);
		logger.debug("FROM THE MyEXCEPTION CLASS : "+ message);
		//error(message);
		// TODO Auto-generated constructor stub
	}







}
