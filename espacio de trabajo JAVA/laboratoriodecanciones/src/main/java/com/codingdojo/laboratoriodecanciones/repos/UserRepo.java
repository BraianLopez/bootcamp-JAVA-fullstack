package com.codingdojo.laboratoriodecanciones.repos;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.laboratoriodecanciones.models.User;

public interface UserRepo extends CrudRepository<User, Long>{

	User  findByEmail(String email);
}
