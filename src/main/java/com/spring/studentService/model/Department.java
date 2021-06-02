package com.spring.studentService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "Department")
public class Department {
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "did")
	@JsonProperty(value = "did")
	private int did;
	@Column(name = "dname")
	private String dname;
	@Column(name = "hod")
	private String hod;

	@JsonIgnore
	@OneToMany(mappedBy = "department" ,cascade = CascadeType.ALL)
	private List<Student> studentDep;


	public int getDid() {
		return did;
	}


	public void setDid(int did) {
		this.did = did;
	}


	public String getDname() {
		return dname;
	}


	public void setDname(String dname) {
		this.dname = dname;
	}


	public String getHod() {
		return hod;
	}


	public void setHod(String hod) {
		this.hod = hod;
	}


	public List<Student> getStudentDep() {
		return studentDep;
	}


	public void setStudentDep(List<Student> studentDep) {
		this.studentDep = studentDep;
	}


	@Override
	public String toString() {
		return "Department [did=" + did + ", dname=" + dname + ", hod=" + hod + ", studentDep=" + studentDep + "]";
	}
	
	
	
}
