package com.uniovi.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Professor {
	@Id
	@GeneratedValue
	private String dni;
	private String name;
	private String apellidos;
	private String field;

	public Professor(String dni, String name,String apellidos,String field) {
		super();
		this.dni = dni;
		this.name = name;
		this.apellidos = apellidos;
		this.field = field;
	}

	public Professor() {
		
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	@Override
	public String toString() {
		return "Profesor [Dni=" + dni + ", nombre=" + name + ", apellidos=" + apellidos + ", categoría=" + field + "]";
	}

	

}
