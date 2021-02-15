package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uniovi.entities.Professor;
import com.uniovi.repositories.ProfessorRepository;

@Service
public class ProfessorService {

	@Autowired
	private ProfessorRepository  profRep;
	
	public List<Professor> getProfessors(){
		List<Professor> professors = new ArrayList<Professor>();
		profRep.findAll().forEach(professors::add);
		return professors;
	}
	
	public Professor getProfessor(String dni){
		return profRep.findById(dni).get();
	}
	
	public void addProfessor(Professor prof){
		profRep.save(prof);
	}
	
	public void deleteProfessor(String dni){
		profRep.deleteById(dni);
	}
	
}
