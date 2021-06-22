package com.spring.studentService.annotations;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class AspectExecutionTime {

	private static final Logger logger = Logger.getLogger(AspectExecutionTime.class) ;
	
	@Around("@annotation(com.spring.studentService.annotations.ExeceutionTime) && execution(* com.spring.studentService.*.*.*(..))")
	public Object excetutionTime(ProceedingJoinPoint jp) throws Throwable {
	
		long startTime = System.currentTimeMillis();
		Object object = jp.proceed();
		long endTime = System.currentTimeMillis();
		logger.debug(startTime+" and "+endTime);
		logger.debug("EXECUTION TIME : "+(endTime-startTime) +" milliseconds "
				+ "\n\tMETHOD SERVICE NAME : "+jp.getSignature().getName());
		return object;
	}
}
