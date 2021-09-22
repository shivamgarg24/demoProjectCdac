package com.test.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.demo.Model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{
	
	Student findByEmailAndPassword(String email,String password);

}
