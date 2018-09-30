package com.apps4society.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class AreaMunicipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Cria a relaçao entre uma Area de Interesse Turistico e uma AreaMuncipio
	 * Um municipio pode conter diversos Atrativos
	 */
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	

}
