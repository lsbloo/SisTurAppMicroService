package com.apps4society.model;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;


@Entity
public class Functions implements GrantedAuthority{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	

	@NotNull
	private String name;
	
	@ManyToMany(mappedBy="roles")
	private Collection<User> users;
	
	@ManyToMany
	@JoinTable(
			name="roles_privileges", joinColumns = @JoinColumn(name="funcoes_id", referencedColumnName
			="id"), inverseJoinColumns = @JoinColumn(name="privileges_id",referencedColumnName="id"))
	private Collection<Privilege> privileges;
	
	
	public Functions() {
		
	}
	public Functions(String name) {
		
		setNomeFuncoes(name);
	}


	@Override
	public String getAuthority() {
		// TODO Auto-generated method stub
		return this.name;
	}
	
	
	public void setNomeFuncoes(String nome) {
		this.name=nome;
	}
	
	public String getNomeFuncoes() {
		return name;
	}


	
	public void setPrivileges(Collection<Privilege> privileges2) {
		// TODO Auto-generated method stub
		
	}


	public Collection<? extends Privilege> getPrivileges() {
		// TODO Auto-generated method stub
		return privileges;
	}
	public Collection<User> getUsers() {
		return users;
	}
	public void setUsers(Collection<User> users) {
		this.users = users;
	}
	
	
	

}
