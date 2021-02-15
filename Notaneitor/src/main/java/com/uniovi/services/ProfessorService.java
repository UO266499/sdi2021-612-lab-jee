package com.uniovi.services;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import com.uniovi.entities.Professor;

public class ProfessorService {

	private List<Professor> professorList = new ArrayList<Professor>();
	
	@PostConstruct
	public void init() {
		professorList.add(new Professor("1234567A", "Edward", "Rolando Nuñez", "SDI"));
		professorList.add(new Professor("2345678B", "Jose Emilio", "Labra Gayo", "ASR"));
		professorList.add(new Professor("1231445C", "Luciano", "Sanchez Ramos", "ASR"));
	}
	
	public List<Professor> getProfessors(){
		return professorList;
	}
	
	public Professor getProfessor(String dni){
		return professorList.stream()
				.filter(prof -> prof.getDni().equals(dni)).findFirst().get();
	}
	
	public void addProfessor(Professor prof){
		 if(prof.getDni() == null) {
		 prof.setDni(professorList.get(professorList.size() - 1).getDni() + 1);
		 }

		 professorList.add(prof);
	}
	
	public void deleteProfessor(String dni){
		professorList.removeIf(prof -> prof.getDni().equals(dni));
	}
	
}
