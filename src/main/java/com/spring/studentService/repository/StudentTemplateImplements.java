package com.spring.studentService.repository;

import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.studentService.model.Department;
import com.spring.studentService.model.Student;
@Repository
public class StudentTemplateImplements implements StudentTemplate {

	@Autowired
	private DataSource datasource;
	
	@Bean
	public JdbcTemplate DepartmentTemplate() {
		
		JdbcTemplate objecTemplate = new JdbcTemplate();
		objecTemplate.setDataSource(datasource);
		return objecTemplate;
	}
	
	JdbcTemplate object;
	 
	static RowMapper<Department> rowmapper =(rs,row)->{
	
		Department department = new Department();
		Student student = new Student();
		department.setDid(rs.getInt("did"));
		department.setDname(rs.getString("dname"));
		department.setHod(rs.getString("hod"));
		
		return department;
	};
	
	
	@Override
	public List<Department> displaystudent() {
		
		object= DepartmentTemplate();
		
		String query ="select d.dname,d.hod,d.did from  department d";
		return object.query(query, rowmapper);
	}

	
	
	
	
	
	
	
	
	
}
