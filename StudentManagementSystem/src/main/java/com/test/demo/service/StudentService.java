package com.test.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.demo.Model.Student;
import com.test.demo.repository.StudentRepository;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository repo;

	public Student login(String email, String password) {
		Student student = repo.findByEmailAndPassword(email, password);
		return student;
	}
}
