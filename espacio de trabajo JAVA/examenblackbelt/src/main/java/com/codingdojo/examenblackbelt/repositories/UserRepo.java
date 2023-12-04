package com.codingdojo.examenblackbelt.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.examenblackbelt.models.User;


public interface UserRepo extends CrudRepository<User, Long>{

	User  findByEmail(String email);
}
