package com.apps4society.model;

import java.util.Collection;
import java.util.List;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="usuarios")
public class User implements UserDetails{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;

	
	@ManyToMany
	@JoinTable(name="usuarios_role",joinColumns= @JoinColumn(
			name="usuarios_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="role_id" , referencedColumnName = "nomeFuncoes"))
	private List<Funcoes> roles;
	
	
	
	@NotNull
	@Column(columnDefinition="text")
	private String nome; // 0
	@NotNull
	@Column(columnDefinition="text")
	private String email; // 1
	@NotNull
	@Column(columnDefinition="text")
	
	private String codigo; // 2
	
	@NotNull
	@Column(columnDefinition="text")
	private String login; // 3
	
	
	@NotNull
	@Column(columnDefinition="text")
	private String pass; // 4
	@NotNull
	@Column(columnDefinition="text")
	private String date_acesso;
	
	public void setNome(String nome) {
		this.nome=nome;
	}
	public String getNome() {
		return nome;
	}
	public void setEmail(String email) {
		this.email=email;
	}
	public String getEmail() {
		return email;
	}
	
	public User() {
		
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getDate_acesso() {
		return date_acesso;
	}
	public void setDate_acesso(String date_acesso) {
		this.date_acesso = date_acesso;
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.pass;
	}
	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.login;
	}
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}
	public List<Funcoes> getRoles() {
		return roles;
	}
	public void setRoles(List<Funcoes> roles) {
		this.roles = roles;
	}
	
}
