package com.codingdojo.autenticacion.repositories;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.autenticacion.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

	User  findByEmail(String email);
}
