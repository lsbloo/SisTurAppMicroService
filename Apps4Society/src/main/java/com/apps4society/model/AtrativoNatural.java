package com.apps4society.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class AtrativoNatural extends AtratativoTuristico{
	/*
	 * Essa clase herda da AtratativoTuristico
	 * Ela é um tipo de atratativo para o modelo;
	 * 
	 * @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	 */
	
	public AtrativoNatural() {
		super();
	}
	
	

}
