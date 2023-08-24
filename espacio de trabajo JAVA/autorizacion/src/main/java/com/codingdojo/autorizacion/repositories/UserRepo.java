package com.codingdojo.autorizacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.autorizacion.models.User;
@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}
