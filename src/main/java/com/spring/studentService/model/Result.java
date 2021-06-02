package com.spring.studentService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Result")
public class Result {
	
	@Id
	@GeneratedValue
	@Column(name = "rid")
	private int rid;
	@Column(name = "sem1")
	private float sem1;
	@Column(name = "sem2")
	private float sem2;
	@Column(name = "sem3")
	private float sem3;
	@Column(name = "sem4")
	private float sem4;
	@Column(name = "sem5")
	private float sem5;
	@Column(name = "sem6")
	private int sem6;
	@Column(name = "sem7")
	private float sem7;
	@Column(name = "sem8")
	private float sem8;
	@Column(name = "total")
	private float total ;
	
	
	@JsonIgnore
	@OneToOne(mappedBy = "result")
	private Student studentResult;


	public int getRid() {
		return rid;
	}


	public void setRid(int rid) {
		this.rid = rid;
	}


	public float getSem1() {
		return sem1;
	}


	public void setSem1(float sem1) {
		this.sem1 = sem1;
	}


	public float getSem2() {
		return sem2;
	}


	public void setSem2(float sem2) {
		this.sem2 = sem2;
	}


	public float getSem3() {
		return sem3;
	}


	public void setSem3(float sem3) {
		this.sem3 = sem3;
	}


	public float getSem4() {
		return sem4;
	}


	public void setSem4(float sem4) {
		this.sem4 = sem4;
	}


	public float getSem5() {
		return sem5;
	}


	public void setSem5(float sem5) {
		this.sem5 = sem5;
	}


	public int getSem6() {
		return sem6;
	}


	public void setSem6(int sem6) {
		this.sem6 = sem6;
	}


	public float getSem7() {
		return sem7;
	}


	public void setSem7(float sem7) {
		this.sem7 = sem7;
	}


	public float getSem8() {
		return sem8;
	}


	public void setSem8(float sem8) {
		this.sem8 = sem8;
	}


	public float getTotal() {
		return total;
	}


	public void setTotal(float total) {
		this.total= total;
	}


	public Student getStudentResult() {
		return studentResult;
	}


	public void setStudentResult(Student studentResult) {
		this.studentResult = studentResult;
	}


	@Override
	public String toString() {
		return "Result [rid=" + rid + ", sem1=" + sem1 + ", sem2=" + sem2 + ", sem3=" + sem3 + ", sem4=" + sem4
				+ ", sem5=" + sem5 + ", sem6=" + sem6 + ", sem7=" + sem7 + ", sem8=" + sem8 + ", total=" + total
				+ ", studentResult=" + studentResult + "]";
	}

	
	
	
	
	
	
	
}
