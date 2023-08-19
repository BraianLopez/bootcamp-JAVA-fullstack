package com.codingdojo.listaestudiantes.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.listaestudiantes.models.ContactInfo;
@Repository
public interface ContactRepo  extends CrudRepository<ContactInfo, Long>{

}
