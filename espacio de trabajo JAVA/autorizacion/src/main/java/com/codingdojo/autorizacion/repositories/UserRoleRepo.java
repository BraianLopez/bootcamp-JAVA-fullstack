package com.codingdojo.autorizacion.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.autorizacion.models.UserRole;
@Repository
public interface UserRoleRepo extends CrudRepository<UserRole, Long>{

}
