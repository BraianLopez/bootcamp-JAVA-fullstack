package com.codingdojo.programastelevision.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.programastelevision.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

	User  findByEmail(String email);
}
