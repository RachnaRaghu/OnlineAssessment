package com.wipro.bed2.entity;

import java.util.Comparator;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name = "TEST")
public class Test implements Comparator<Test>{

	Date testDate;
	String assessment;
	int marks;
	@Id
	String email;
	String result;
	
    public Test() {
		
	}
	
	public Test(Date testDate, String assessment, int marks, String email, String result) {
		super();
		this.testDate = testDate;
		this.assessment = assessment;
		this.marks = marks;
		this.email = email;
		this.result = result;
	}
	public Date getTestDate() {
		return testDate;
	}
	public void setTestDate(Date testDate) {
		this.testDate = testDate;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	
	public String getAssessment() {
		return assessment;
	}
	public void setAssessment(String assessment) {
		this.assessment = assessment;
	}
	public int getMarks() {
		return marks;
	}
	public void setMarks(int marks) {
		this.marks = marks;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Override
	public String toString() {
		return "Test [testDate=" + testDate + ", assessment=" + assessment + ", marks=" + marks
				+ ", email=" + email + ", result=" + result + "]";
	}
	@Override
	public int compare(Test o1, Test o2) {
		return o1.testDate.compareTo(o2.testDate);
	}
}
