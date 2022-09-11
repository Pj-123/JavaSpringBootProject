package com.order.app.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.app.exception.CustomException;
import com.order.app.models.User;
import com.order.app.repository.OrderApplication;
import com.order.app.services.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private OrderApplication orderapplication;
	
	@Override
	public User saveStudent(User user) {
		// TODO Auto-generated method stub
		return orderapplication.save(user);
	}

	@Override
	public User getStudentById(int id) {
		// TODO Auto-generated method stub
		Optional<User> value=orderapplication.findById(id);
		if(value.isPresent()) {
			return value.get();
			
		}
		else {
			throw new CustomException("User", "Id", id);
		}
						
				
	
	}

	@Override
	public List<User> getAllStudents() {
		// TODO Auto-generated method stub
		return (List<User>) orderapplication.findAll();
	}

	@Override
	public User updateStudentById(User user, int id) {
		// TODO Auto-generated method stub
		User value=orderapplication.findById(id).orElseThrow(()-> new CustomException("User", "Id", id));
		value.setFirstname(user.getFirstname());
		value.setLastname(user.getLastname());
		orderapplication.save(value);
		return value;
//		User ws=orderapplication.save(value);
//		return ws;
		
	
			
			
		}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		orderapplication.findById(id).orElseThrow(()->new CustomException("User", "Id", id));
		orderapplication.deleteById(id); 
		
	}
	

}
