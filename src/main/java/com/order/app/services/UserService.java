package com.order.app.services;

import java.util.List;

import com.order.app.models.User;

public interface UserService {

	User saveStudent(User user);
	User getStudentById(int id);
	List<User> getAllStudents();
	User updateStudentById(User user, int id);
	void deleteStudent(int id);
	
}
