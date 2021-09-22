package com.test.demo.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.test.demo.Model.Student;
import com.test.demo.exceptions.ResourceNotFoundException;
import com.test.demo.repository.StudentRepository;
import com.test.demo.service.StudentService;

@Controller
public class StudentController {

	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private StudentService studentService;
	
	@RequestMapping("/") 
	  public String welcomePage()
	  {
		  return "welcome1";
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

/* @RequestMapping(path={"/userss"} , method = RequestMethod.POST)
public @ResponseBody String createUser( User user)
{
	  userRepository.save(user);
	  return "out.html";
} */

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

@GetMapping("/login")
	public ModelAndView login() {
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("student", new Student());
		return mv;
	}


	@PostMapping("/loginstudent")
	public String login(@ModelAttribute("student") Student student) {
		System.out.println(student.getEmail());
		System.out.println(student.getPassword());
		Student oauthStudent = studentService.login(student.getEmail(), student.getPassword());
		System.out.println(oauthStudent);

		if(Objects.nonNull(oauthStudent)) {
			return "redirect:/index";
			}
		else {
			return "redirect:/login";
		}
	}

	@RequestMapping("/index")
	public String logged()
	  {
		  return "index";
	  }


/*	@Autowired
  private org.springframework.core.env.Environment environment;
  @GetMapping("/checkProfile")
  public String[] checkProfile() {
      String[] activeProfiles = environment.getActiveProfiles();  
      for(String profile:activeProfiles) {
          System.out.print(profile);
      }
      return activeProfiles;
  }
	*/


}