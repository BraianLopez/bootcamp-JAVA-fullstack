package com.codingdojo.examenblackbelt.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.examenblackbelt.models.Course;
import com.codingdojo.examenblackbelt.repositories.CoursesRepo;

@Service
public class CoursesService {

	private final CoursesRepo coursesRepo;
	public CoursesService(CoursesRepo cRe) {
		this.coursesRepo = cRe;
	}
	
	public Course crearCurso(Course curso) {
		return coursesRepo.save(curso);
	}
	public List<Course> todosCursos(){
		return coursesRepo.findAll();
	}
}
