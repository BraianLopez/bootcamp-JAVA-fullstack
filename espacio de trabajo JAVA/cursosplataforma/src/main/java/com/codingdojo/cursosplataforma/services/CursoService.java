package com.codingdojo.cursosplataforma.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.cursosplataforma.models.Curso;
import com.codingdojo.cursosplataforma.repositories.CursoRepo;

@Service
public class CursoService {
	private final CursoRepo cursoRepo;
	public CursoService(CursoRepo cRe) {
		this.cursoRepo= cRe;
	}
	public List<Curso> todosCursos(){
		return cursoRepo.findAll();
	}
	public Curso crearCurso(Curso curso) {
		return cursoRepo.save(curso);
	}
}
