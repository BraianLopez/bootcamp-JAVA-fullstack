package com.codingdojo.cursosplataforma.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.cursosplataforma.models.User;

public interface UserRepo  extends CrudRepository<User,Long>{

	
	 User findByEmail(String email);
	}

