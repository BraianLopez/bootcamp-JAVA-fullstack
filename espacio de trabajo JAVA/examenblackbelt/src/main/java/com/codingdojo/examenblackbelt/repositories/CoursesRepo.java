package com.codingdojo.examenblackbelt.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.codingdojo.examenblackbelt.models.Course;

public interface CoursesRepo extends CrudRepository<Course, Long> {

	
	List<Course> findAll();
}
