package com.codingdojo.eventos.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.eventos.models.User;
@Repository
public interface UserRepo extends CrudRepository<User, Long>{

	User  findByEmail(String email);
}
