package com.apps4society.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
@Entity
public class Funcoes implements GrantedAuthority{

	@Id
	private String nomeFuncoes;
	
	@ManyToMany
	private List<User> users;
	
	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.nomeFuncoes;
	}
	
	
	public void setNomeFuncoes(String nome) {
		this.nomeFuncoes=nome;
	}
	
	public String getNomeFuncoes() {
		return nomeFuncoes;
	}
	
	
	

}
