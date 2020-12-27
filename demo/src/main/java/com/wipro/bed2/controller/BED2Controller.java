package com.wipro.bed2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.wipro.bed2.dao.StudentRepository;
import com.wipro.bed2.dao.TestRepository;

import com.wipro.bed2.entity.Student;
import com.wipro.bed2.entity.Test;

@Controller
public class BED2Controller {

	@Autowired
	TestRepository assmntRepo;

	@Autowired
	StudentRepository studentRepo;
	
	@Autowired
	Student currentStudent;

	public BED2Controller(TestRepository assmntRepo) {
		this.assmntRepo = assmntRepo;
	}


	@RequestMapping("/")
	public String login() {
		return "Login";
	}

	@PostMapping("/checkUser")
	public String checkingUser(@RequestParam("email") String email, @RequestParam("password") String password) {
		Student student = new Student();
		if (studentRepo.existsById(email)) {
		student = studentRepo.findByEmail(email);
		System.out.println("--Student--" + student);
		if (student.getUserType().equals("admin")) {
			if (student.getPassword().equals(password)) {

				currentStudent = student;
				return "adminSelectReport";
			}

			else
				return "passwordWrong";
		}

		else if (student.getUserType().equals("candidate")) {
			if (student.getPassword().equals(password)) {
				currentStudent = student;
				return "testSelection";
			} else
				return "passwordWrong";
		} 
		
		}
		return "invalidUser";
	}

	@GetMapping("/springAssessment")
	
	public String getSpringtest() {
		return "springAssesment";
	}

	@GetMapping("/hibernateAssessment.html")
	
	public String getHibernatetest() {
		return "hibernateAssesment";
	}

	@GetMapping("/users/all")
	public String getUsersList(Model theModel) {
		List<Student> students = new ArrayList<>();
	    studentRepo.findAll().forEach(students::add);		
	  
		theModel.addAttribute("users", students);
		return "usersDetail";
	}
	

	@GetMapping("/asessement/all")
	public String getTestsList(Model theModel) {
		theModel.addAttribute("tests", assmntRepo.findAll());
		return "testList";
	}

	@GetMapping("/Registration")
	public String newRegistration() {

		return "Registration";
	}

	@PostMapping("/registration/do")
	public String RegisterConfirm(
			// @ModelAttribute Student Student, Model theModel) {
			@RequestParam("firstname") String firstName, @RequestParam("lastname") String lastName,
			@RequestParam String email, @RequestParam String password, Model theModel) {
		Student student = new Student(firstName, lastName, email, password, "candidate");
		theModel.addAttribute("u", student);
		studentRepo.save(student);
		return "registrationConfirm";
	}

	@PostMapping("/evaluate/spring/test")
	public String checkSpring(@RequestParam("Question1") String a1, @RequestParam("Question2") String a2,
			@RequestParam("Question3") String a3, @RequestParam("Question4") String a4,
			@RequestParam("Question5") String a5) {
		int marks = 0;
		Date testDate = new Date();
		String assessment = "SpringTest";
		if (a1.equals("J2EE App Development Framework"))
			marks += 10;
		if (a2.equals("Inversion Of Control"))
			marks += 10;
		if (a3.equals("Aspect Oriented Programming"))
			marks += 10;
		if (a4.equals("Application Context"))
			marks += 10;
		if (a5.equals("Dispatcher Servlet"))
			marks += 10;
		System.out.println("marks in spring--" + marks);
		String result = (marks >= 30) ? "Passed" : "Failed";
		System.out.println("Student--test--" + currentStudent);
		System.out.println("--assess--" + assessment);
		Test t = new Test(testDate, assessment, marks, currentStudent.getEmail(), result);
		System.out.println("--" + testDate + "--");
		assmntRepo.save(t);
		if (marks >= 30)
			return "resultPass";
		else
			return "failurePage";
	}

	@PostMapping("/evaluate/hibernate/test")
	public String checkHibernate(@RequestParam("Question1") String a1, @RequestParam("Question2") String a2,
			@RequestParam("Question3") String a3, @RequestParam("Question4") String a4,
			@RequestParam("Question5") String a5) {
		int marks = 0;
		Date testDate = new Date();
		String assessment = "Hibernate-L1";
		if (a1.equals("Object Relational Mapping"))
			marks += 10;
		if (a2.equals("uni-directional & bi-directional"))
			marks += 10;
		if (a3.equals("configuration file"))
			marks += 10;
		if (a4.equals("Hibernate Query Language"))
			marks += 10;
		if (a5.equals("isolation levels"))
			marks += 10;
		System.out.println("marks in hibernate--" + marks);
		Test t = new Test(testDate, assessment, marks, currentStudent.getEmail(),
				(marks >= 30) ? "Passed" : "Failed");
		System.out.println("date--" + testDate + "--");
		assmntRepo.save(t);
		if (marks >= 30)
			return "resultPass";
		else
			return "failurePage";
	}

	@GetMapping("/home")
	public String logout() {
		currentStudent = null;
		return "Login";
	}
}
