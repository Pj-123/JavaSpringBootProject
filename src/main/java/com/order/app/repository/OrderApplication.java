package com.order.app.repository;

import org.springframework.data.repository.CrudRepository;

import com.order.app.models.User;

public interface OrderApplication extends CrudRepository<User, Integer>{

}
