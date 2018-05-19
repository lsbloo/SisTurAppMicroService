package com.apps4society.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


public class Geoparque extends AtrativoNatural{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	public Geoparque() {
		super();
	}

}
