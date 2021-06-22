package com.spring.studentService.exception;

import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExceptionAspect {
	
	@Autowired MyException exception;
	@Pointcut("@annotation(com.spring.studentService.annotations.MyAnnotation) && execution(public * *(..))" )
	public void check() {
		
	}

	@AfterThrowing(pointcut = "check()",throwing = "ex")
	public void anno(MyException ex)  {

		System.out.println("EXCEPTION FROM ANNOTATION : "+exception.arith("HI"));
	}
	
	
}
