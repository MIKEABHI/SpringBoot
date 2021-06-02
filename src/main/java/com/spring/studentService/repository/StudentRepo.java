package com.spring.studentService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.spring.studentService.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	
//STUDENT BY ID ----STUDENT & FINAL RESULT
	@Query(value ="select student.sid,student.fname,student.lname,student.batch , result.total "
			+ "from student ,result where student.result_id = result.rid and student.sid=:id",nativeQuery = true)
	public List<Object[]> studentResult(@Param("id") int id);

//STUDENT BY DEPARTMENT ----STUDENT & FINAL RESULT	
	@Query(value = "select student.sid,student.fname,student.lname,student.batch , result.total "
			+ " from student ,result where  student.result_id = result.rid and "
			+ " student.department_did=(select department.did from department where department.dname=:name)",nativeQuery =true)
	public List<Object[]> studentDepartment(@Param("name") String name);





}   
