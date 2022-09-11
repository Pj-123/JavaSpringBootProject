package com.order.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.app.models.User;
import com.order.app.services.UserService;

@RestController
// @RequestMapping("/student")
public class Controller {
	
	@Autowired
	private UserService userservice;
	
	@PostMapping("/submit")
	public ResponseEntity<User> createStudent(@RequestBody User user){
		return new ResponseEntity<User>(userservice.saveStudent(user),HttpStatus.CREATED);
		
	}
	
	@GetMapping("/list")
	public List<User> getAllList(){
		return userservice.getAllStudents();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<User> getStudentWithId(@PathVariable ("id") int id){
		return new ResponseEntity<User>(userservice.getStudentById(id), HttpStatus.OK);
	}
 
	@PutMapping("{id}")
	public ResponseEntity<User> updateStudent(@PathVariable("id") int id, @RequestBody User user){
		return new ResponseEntity<User>(userservice.updateStudentById(user, id), HttpStatus.CREATED);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable ("id") int id){
		userservice.deleteStudent(id);
		return new ResponseEntity<String>("deleted Successfully", HttpStatus.OK);
	}
}
