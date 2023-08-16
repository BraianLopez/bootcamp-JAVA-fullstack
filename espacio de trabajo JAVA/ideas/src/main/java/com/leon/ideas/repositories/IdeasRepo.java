package com.leon.ideas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.leon.ideas.models.IdeasModel;

@Repository
public interface IdeasRepo extends CrudRepository <IdeasModel,Long> {

    //Este método recupera todos las ideas de la base de datos
    List<IdeasModel> findAll(); 
}
