package com.test.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.demo.Model.Cc;
import com.test.demo.Model.Student;
import com.test.demo.exceptions.ResourceNotFoundException;
import com.test.demo.repository.CcRepository;
import com.test.demo.repository.StudentRepository;

@RestController
@RequestMapping("/Cc")
public class CcController {
	
	 @Autowired
	  private StudentRepository studentRepository;
	  private CcRepository ccrepository;


	  @PostMapping("/new")
	  public Cc createCC(@RequestBody Cc cc) {
	    return ccrepository.save(cc);
	  }

	  @GetMapping("/students")
	  public List<Student> getAllStudentss() {
	    return studentRepository.findAll();
	  }

	  @GetMapping("/students/{id}")
	  public ResponseEntity<Student> getUsersById(@PathVariable(value = "id") Long studentId)
	      throws ResourceNotFoundException {
	    Student student =
	        studentRepository
	            .findById(studentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + studentId));
	    return ResponseEntity.ok().body(student);
	  }


	  @PostMapping("/students")
	  public Student createUser(@RequestBody Student student) {
	    return studentRepository.save(student);
	  }
	  
	  
	  @PutMapping("/students/{id}")
	  public ResponseEntity<Student> updateStudent(
	      @PathVariable(value = "id") Long studentId, @RequestBody Student studentDetails)
	      throws ResourceNotFoundException {

	    Student student =
	        studentRepository
	            .findById(studentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + studentId));

	    student.setFirstName(studentDetails.getFirstName());
	    student.setLastName(studentDetails.getLastName());
	    student.setEmail(studentDetails.getEmail());
	    student.setPassword(studentDetails.getPassword());
	    student.setAddress(studentDetails.getAddress());
	    student.setContact(studentDetails.getContact());
	   // user.setUpdatedAt(new Date());
	    final Student updatedStudent = studentRepository.save(student);
	    return ResponseEntity.ok(updatedStudent);
	  }

	  @DeleteMapping("/student/{id}")
	  public Map<String, Boolean> deleteStudent(@PathVariable(value = "id") Long studentId) throws Exception {
	    Student student =
	        studentRepository
	            .findById(studentId)
	            .orElseThrow(() -> new ResourceNotFoundException("Student not found on :: " + studentId));

	    studentRepository.delete(student);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
	
}