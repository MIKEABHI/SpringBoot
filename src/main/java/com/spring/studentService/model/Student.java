package com.spring.studentService.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Student")
public class Student {

	@Id
	@GeneratedValue
	@Column(name = "sid")
	private int sid;
	@Column(name = "fname")
	private String fname;
	@Column(name = "lname")
	private String lname;
	@Column(name = "batch")
	private String batch;

	

	@ManyToOne(cascade = CascadeType.MERGE)
//	@JoinColumn(name = "Dep_Id",referencedColumnName = "did")
	private Department department;
	
	@OneToOne(cascade  = CascadeType.ALL)
	@JoinColumn(name = "Result_Id",referencedColumnName = "rid")
	private Result result;
	
	@ManyToMany(cascade = CascadeType.MERGE)
 //   @JoinColumn(name="sportId",referencedColumnName = "sportId")
	@JoinTable(name="Student_Sports",joinColumns= @JoinColumn(name="sid") ,
	inverseJoinColumns= @JoinColumn(name="sportId"))
	private List<Sport> sports;
 


	public Student(int i, String string, String string2, String string3) {
		// TODO Auto-generated constructor stub
	}


	public int getSid() {
		return sid;
	}


	public void setSid(int sid) {
		this.sid = sid;
	}


	public String getFname() {
		return fname;
	}


	public void setFname(String fname) {
		this.fname = fname;
	}


	public String getLname() {
		return lname;
	}


	public void setLname(String lname) {
		this.lname = lname;
	}


	public String getBatch() {
		return batch;
	}


	public void setBatch(String batch) {
		this.batch = batch;
	}


	public Result getResult() {
		return result;
	}


	public void setResult(Result result) {
		this.result = result;
	}


	public Department getDepartment() {
		return department;
	}


	public void setDepartment(Department department) {
		this.department = department;
	}


	public List<Sport> getSports() {
		return sports;
	}


	public void setSports(List<Sport> sports) {
		this.sports = sports;
	}

	

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return "Student [sid=" + sid + ", fname=" + fname + ", lname=" + lname + ", batch=" + batch + "]";
	}



	
	
	
}
