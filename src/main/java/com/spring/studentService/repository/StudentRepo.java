package com.spring.studentService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.studentService.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
//STUDENT BY ID ----ALL DETAILS	
	public Student findBySid(int id);
	
	
//STUDENT BY ID ----STUDENT & FINAL RESULT
	@Query(value ="select student.sid,student.fname,student.lname,department.dname,student.batch , result.total "
			+ "from student,department,result where student.result_id = result.rid and student.sid=:id "
			+ " and student.department_did=department.did",nativeQuery = true)
	public List<Object[]> studentResult(@Param("id") int id);

//STUDENT BY DEPARTMENT ----STUDENT & FINAL RESULT	
	@Query(value = "select student.sid,student.fname,student.lname,student.batch , result.total "
			+ " from student ,result where  student.result_id = result.rid and "
			+ " student.department_did=(select department.did from department where department.dname=:name)",nativeQuery =true)
	public List<Object[]> studentDepartment(@Param("name") String name);
	
//STUDENTS RESULTS ABOVE THE MARK ---STUDENT & DEPARTMENT & FINAL RESULT
@Query(value = "select  student.sid,student.fname,student.lname,student.batch,department.dname, result.total from "
		+ "student ,result,department where student.result_id = result.rid and student.department_did = department.did "
		+ "and result.total >= :mark", nativeQuery = true)
	public List<Object[]> resultAbove(@Param("mark") float mark);
	
//STUDENTS RESULTS BELOW THE MARK ---STUDENT & DEPARTMENT & FINAL RESULT
	@Query(value = "select  student.sid,student.fname,student.lname,student.batch,department.dname, result.total from "
			+ "student ,result,department where student.result_id = result.rid and student.department_did = department.did "
			+ "and result.total <= :mark", nativeQuery = true)
		public List<Object[]> resultBelow(@Param("mark") float mark);	

//STUDENTS RESULTS BETWEEN THE MARKS ---STUDENT & DEPARTMENT & FINAL RESULT
		@Query(value = "select  student.sid,student.fname,student.lname,student.batch,department.dname, result.total from "
				+ "student ,result,department where student.result_id = result.rid and student.department_did = department.did "
				+ "and result.total between :mark1 and :mark2", nativeQuery = true)
		public List<Object[]> resultBetween(@Param("mark1") float mark1,@Param("mark2") float mark2);		

//STUDENTS BY SPORT ---STUDENT & DEPARTMENT & SPORT
		@Query(value = "select student.sid,student.fname,student.lname,department.dname,student.batch,sport.sportname from "
				+ " student , sport ,department , student_sports ss where student.department_did=department.did and "
				+ " student.sid = ss.sid and sport.sport_id =ss.sport_id and sport.sportname= :sport",nativeQuery = true)
		public List<Object[]> studentSport(@Param("sport") String sport);
}   
