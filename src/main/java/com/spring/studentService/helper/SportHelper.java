package com.spring.studentService.helper;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.studentService.model.Sport;
import com.spring.studentService.model.Student;
import com.spring.studentService.repository.SportRepo;

@Service
public class SportHelper {

	private static final Logger logger = Logger.getLogger(SportHelper.class) ;
	
	@Autowired
	SportRepo sportRepo;
	
	public List<Student> helpSport(List<Student> data){

		 for (Student student : data) {

			 List<Sport> sports = student.getSports();
			for (Sport sport : sports) {
				Sport sport2=sportRepo.findBySportname(sport.getSportname());
				sport.setSportId(sport2.getSportId());
				sport.setSportname(sport2.getSportname());
			}
			student.setSports(sports);
		}
		 logger.debug("ASIIGNING SPORT DETAILS BY SPORT NAME");
			return data;
		}
}
