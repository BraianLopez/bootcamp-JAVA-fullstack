package com.codingdojo.listaestudiantes.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.listaestudiantes.models.ContactInfo;
import com.codingdojo.listaestudiantes.models.Student;
import com.codingdojo.listaestudiantes.repositories.ContactRepo;
import com.codingdojo.listaestudiantes.repositories.StudentRepo;

@Service
public class MainService {

	@Autowired
	private StudentRepo studentRepo;
	@Autowired
	private ContactRepo contactRepo;
	
	public List<Student> todosEstudiantes() {
		return studentRepo.findAll();
	}

	public Student createStudent(Student student) {
		return studentRepo.save(student);
	}
	public ContactInfo createContactInfo(ContactInfo contactInfo) {
		return contactRepo.save(contactInfo);
	}
	 public List<Student> studentSinContactInfo(){
			return studentRepo.findNoContactInfo();
		}
}
