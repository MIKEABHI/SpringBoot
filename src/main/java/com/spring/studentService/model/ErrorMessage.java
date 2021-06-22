package com.spring.studentService.model;

import org.springframework.http.HttpStatus;

public class ErrorMessage {

	private HttpStatus status;
	private String message;
	private String error;
	
	
	
	public ErrorMessage() {
		super();
	
	}
	public ErrorMessage(HttpStatus status, String message, String error) {
		super();
		this.status = status;
		this.message = message;
		this.error = error;
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	
}
