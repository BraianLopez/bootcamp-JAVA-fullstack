package com.codingdojo.eventos.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.eventos.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

	User  findByEmail(String email);
}
