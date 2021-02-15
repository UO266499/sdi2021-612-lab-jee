package com.uniovi.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.uniovi.entities.Professor;
import com.uniovi.services.ProfessorService;


@Controller
public class ProfessorControllers {

	@Autowired
	private ProfessorService professorService;
	
	@RequestMapping("/professor/list")
	public String getList(Model model){
		model.addAttribute("professorList",	professorService.getProfessors());
		return "professor/list";
	}
	@RequestMapping(value="/professor/add", method=RequestMethod.POST )
	public String setProfessor(@RequestParam String dni,
			@RequestParam String name,@RequestParam String surname, @RequestParam String field){
		professorService.addProfessor(new Professor(dni, name, surname, field));
		return "redirect:/professor/list";
	}
	
	@RequestMapping("/professor/name/{id}")
	public String getName(Model model, @PathVariable String dni){
		model.addAttribute("professor", professorService.getProfessor(dni).getName());
		return "professor/name";
	}
	
	@RequestMapping("/professor/dni/{id}")
	public String getDni(Model model, @PathVariable String dni){
		model.addAttribute("professor", professorService.getProfessor(dni).getDni());
		return "professor/dni";
	}
	
	@RequestMapping("/professor/surname/{id}")
	public String getSurname(Model model, @PathVariable String dni){
		model.addAttribute("professor", professorService.getProfessor(dni).getApellidos());
		return "professor/surname";
	}
	
	@RequestMapping("/professor/field/{id}")
	public String getField(Model model, @PathVariable String dni){
		model.addAttribute("professor", professorService.getProfessor(dni).getField());
		return "professor/field";
	}
	
	@RequestMapping("/professor/delete/{id}" )
	public String deleteProfessor(@PathVariable String dni){
		professorService.deleteProfessor(dni);
		return "redirect:/professor/list";
	}
	
	@RequestMapping(value="/professor/edit/{id}", method=RequestMethod.POST)
	public String setEdit(Model model, @PathVariable String dni,@PathVariable String name,@PathVariable String apellidos,
			@PathVariable String categoria, @ModelAttribute Professor prof){
		prof.setDni(dni);
		prof.setApellidos(apellidos);
		prof.setField(categoria);
		prof.setName(name);
		professorService.addProfessor(prof);
		return "redirect:/professor/list";
	}
}
