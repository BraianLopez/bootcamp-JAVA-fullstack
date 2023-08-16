package com.leon.ideas.repositories;

import org.springframework.data.repository.CrudRepository;

import com.leon.ideas.models.UserModel;


public interface UserRepo extends CrudRepository<UserModel, Long> {
	
	UserModel findByEmail(String email);
	
}
