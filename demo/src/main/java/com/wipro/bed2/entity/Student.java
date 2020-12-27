package com.wipro.bed2.entity;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import org.springframework.stereotype.Component;
@Entity
@Table(name = "STUDENT")
@Component
public class Student implements Comparator<Student>{
	
	@Id
	private String email;
	private String firstName;
	private String lastName;
	private String password;
	private String userType;
	
	public Student() {
		this.userType="candidate";
	}
	
	public Student(String firstName, String lastName, String email, String password, String userType) {
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.userType = userType;
	}

	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	@Override
	public String toString() {
		return "Student [email=" + email + ", firstName=" + firstName + ", lastName=" + lastName + ", password="
				+ password + ", userType=" + userType + "]";
	}
	
	@Override
	public int compare(Student o1, Student o2){
		return o1.firstName.compareToIgnoreCase(o2.firstName);
	}

}
