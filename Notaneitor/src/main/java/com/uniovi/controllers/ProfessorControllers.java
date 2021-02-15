package com.uniovi.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ProfessorControllers {

	@RequestMapping("/professor/list")
	public String getList(){
		return "Getting List";
	}
	@RequestMapping(value="/professor/add", method=RequestMethod.POST )
	public String setProfessor(@RequestParam String dni,
			@RequestParam String name,@RequestParam String surname, @RequestParam String field){
		return "Adding professor with dni: " +dni+", name: "+ name +" with surname: "+ surname+ " and field: " + field;
	}
	
	@RequestMapping("/professor/name")
	public String getName(){
		return "Getting nombre";
	}
	
	@RequestMapping("/professor/dni")
	public String getDni(){
		return "Getting DNI";
	}
	
	@RequestMapping("/professor/surname")
	public String getSurname(){
		return "Getting apellidos";
	}
	@RequestMapping("/professor/field")
	public String getField(){
		return "Getting categoría";
	}
}
