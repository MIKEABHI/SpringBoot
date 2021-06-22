package com.spring.studentService.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.spring.studentService.model.ErrorMessage;

@ControllerAdvice
public class HandlerException extends ResponseEntityExceptionHandler{

	@ExceptionHandler(MyException.class)  
    public ResponseEntity<Object> handleInvalidAddressException(MyException ex, HttpServletRequest request) 
    {
     
		String message = "FROM THE EXCEPTION HANDLER ";
		ErrorMessage errorMessage = new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage(), message);
		
        return new ResponseEntity<Object>(errorMessage, errorMessage.getStatus());
    }
	


	
}
