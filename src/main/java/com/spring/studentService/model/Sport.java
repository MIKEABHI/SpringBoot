package com.spring.studentService.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Sport")
public class Sport {
	
	@Id
	@GeneratedValue
	@Column(name = "sportId")
	private int sportId;
	@Column(name = "sportname")
	private String sportname;
	
	
	@JsonIgnore
	@ManyToMany(mappedBy = "sports")
	private List<Student> studentSport;


	
	
	public int getSportId() {
		return sportId;
	}


	public void setSportId(int sportId) {
		this.sportId = sportId;
	}


	public String getSportname() {
		return sportname;
	}


	public void setSportname(String sportname) {
		this.sportname = sportname;
	}


	public List<Student> getStudentSport() {
		return studentSport;
	}


	public void setStudentSport(List<Student> studentSport) {
		this.studentSport = studentSport;
	}

	
	
	
}
