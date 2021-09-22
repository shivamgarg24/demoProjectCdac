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

import com.test.demo.Model.Faculty;
import com.test.demo.exceptions.ResourceNotFoundException;
import com.test.demo.repository.FacultyRepository;

@RestController
@RequestMapping("/sms/sms1")
public class FacultyController {

	
	 @Autowired
	  private FacultyRepository facultyRepository;


	  @GetMapping("/faculty")
	  public List<Faculty> getAllFaculties() {
	    return facultyRepository.findAll();
	  }

	  @GetMapping("/faculty/{id}")
	  public ResponseEntity<Faculty> getFacultiesById(@PathVariable(value = "id") Long facultyId)
	      throws ResourceNotFoundException {
	    Faculty faculty =
	       facultyRepository
	            .findById(facultyId)
	            .orElseThrow(() -> new ResourceNotFoundException("Faculty not found on :: " + facultyId));
	    return ResponseEntity.ok().body(faculty);
	  }

	  @PostMapping("/faculty")
	  public Faculty createFaculty(@RequestBody Faculty faculty) {
	    return facultyRepository.save(faculty);
	  }

	  @PutMapping("/faculty/{id}")
	  public ResponseEntity<Faculty> updateFaculty(
	      @PathVariable(value = "id") Long facultyId,	@RequestBody Faculty facultyDetails)
	      throws ResourceNotFoundException {

	    Faculty faculty =
	        facultyRepository
	            .findById(facultyId)
	            .orElseThrow(() -> new ResourceNotFoundException("Faculty not found on :: " + facultyId));

	    faculty.setEmail(facultyDetails.getEmail());
	    faculty.setLastName(facultyDetails.getLastName());
	    faculty.setFirstName(facultyDetails.getFirstName());
	    faculty.setPass(facultyDetails.getPass());
	    faculty.setSalary(facultyDetails.getSalary());
	   // user.setUpdatedAt(new Date());
	    final Faculty updatedFaculty = facultyRepository.save(faculty);
	    return ResponseEntity.ok(updatedFaculty);
	  }

	  @DeleteMapping("/faculty/{id}")
	  public Map<String, Boolean> deleteFaculty(@PathVariable(value = "id") Long facultyId) throws Exception {
	    Faculty faculty =
	        facultyRepository
	            .findById(facultyId)
	            .orElseThrow(() -> new ResourceNotFoundException("Faculty not found on :: " + facultyId));

	    facultyRepository.delete(faculty);
	    Map<String, Boolean> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);
	    return response;
	  }
}