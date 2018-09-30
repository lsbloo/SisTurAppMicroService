package com.apps4society.model;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.io.Serializable;

@Entity
public class Privilege implements Serializable{
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	
	
	private String name;
	
	@ManyToMany(mappedBy="privileges")
	private Collection<Funcoes> funcoes;

	public Privilege(String name2) {
		// TODO Auto-generated constructor stub
		setName(name2);
	}
	public Privilege() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
