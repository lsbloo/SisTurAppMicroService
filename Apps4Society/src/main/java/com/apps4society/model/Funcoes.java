package com.apps4society.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import org.springframework.security.core.GrantedAuthority;
@Entity
public class Funcoes implements GrantedAuthority{
	
	
	
	/*
	 * Estabelece uma funcao para um usuario "role". regra de permissão de acesso
	 * é necessario na criação de um usuario estabelecer o mesmo.
	 * 
	 * @Manytomany = muitos para muitos -- um usuario pode ter mais de uma funcao
	 * exxemplo osvaldo(admin,user)
	 * !
	 * o JPA realiza essas configurações implicitamente na criação do BD
	 * é necessario tomar cuidado nesses relacionamentos
	 * (Pesquisar M).
	 * 
	 */

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
