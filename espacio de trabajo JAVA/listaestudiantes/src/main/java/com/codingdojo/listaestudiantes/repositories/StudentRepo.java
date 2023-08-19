package com.codingdojo.listaestudiantes.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.listaestudiantes.models.Student;
@Repository
public interface StudentRepo extends CrudRepository<Student, Long>{
	List<Student> findAll();
	@Query(value="SELECT s.* FROM students s LEFT OUTER JOIN contacts c ON s.id=c.student_id WHERE c.id IS NULL", nativeQuery=true)
	List<Student> findNoContactInfo();
}
