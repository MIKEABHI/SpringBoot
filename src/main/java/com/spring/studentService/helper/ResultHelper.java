package com.spring.studentService.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.spring.studentService.model.Result;
import com.spring.studentService.model.Student;

@Service
public class ResultHelper {
	
	private static final Logger logger = Logger.getLogger(ResultHelper.class) ;
	@Value("${number_of_sem}")
 private String divide ;
	public float total(Result result) {
		float total=(result.getSem1()+result.getSem2()+result.getSem3()+result.getSem4()+result.getSem5()
		                      +result.getSem6()+result.getSem7()+result.getSem8())/Integer.parseInt(divide);
		logger.debug("TOTAL IS CALCULATED AS  "+ total);
		return  total;
	}
	
	public List<Student> helpResult(List<Student> data) {
		
		for (Student student : data) {
			Result result =student.getResult();
			float total = total(result);
			result.setTotal(total);
		}
		logger.debug("RESULT IS CALCULATED AND UPDATED TO EACH STUDENT ");
		return data;
	}
	
	
}
