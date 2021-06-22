package com.spring.studentService.repository;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.spring.studentService.model.Department;
@Repository
public class DepartmentTemplateImplements implements DepartmentTemplate {

	@Autowired
	private DataSource datasource;
	
	@Bean
	public JdbcTemplate departmentTemplate() {
		
		JdbcTemplate objecTemplate = new JdbcTemplate();
		objecTemplate.setDataSource(datasource);
		return objecTemplate;
	}
	
	JdbcTemplate object;
	 
	static RowMapper<Department> rowmapper =(rs,row)->{
	
		Department department = new Department();
		department.setDid(rs.getInt("did"));
		department.setDname(rs.getString("dname"));
		department.setHod(rs.getString("hod"));
		
		return department;
	};
	
	
	@Override
	public List<Department> displayDepartment() {
		
		object= departmentTemplate();
		
		String query ="select *from  department ";
		return object.query(query, rowmapper);
	}

	
	
	
	
	
	
	
	
	
}
