package com.wipro.bed2.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.wipro.bed2.entity.Student;


public interface StudentRepository extends CrudRepository<Student, String>{
	

	Student findByEmail(String email);
}
