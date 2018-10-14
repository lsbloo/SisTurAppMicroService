package com.apps4society.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
@Table(name="usuarios")
public class User implements UserDetails,Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long id;

	
	@ManyToMany
	@JoinTable(name="usuarios_role",joinColumns= @JoinColumn(
			name="usuarios_id", referencedColumnName="id"),
	inverseJoinColumns = @JoinColumn(name="role_id" , referencedColumnName = "id"))
	private Collection<Funcoes> roles;
	
	
	
	
	
	@NotNull
	@Column(name="actived")
	public boolean actived;
	
	
	
	@Column(name="experacaoToken")
	public boolean expiracaoToken;
	
	
	@NotBlank(message="Nome é obrigatório")
	@Column(name="nome")
	public String nome; // 0
	
	@NotBlank(message="Email é obrigatório")
	@Column(name="email")
	public String email; // 1
	
	

	@NotBlank(message="Login é obrigatório")
	@Column(name="login")
	public String login; // 3
	
	

	@NotBlank(message="Senha é obrigatório")
	@Column(name="password")
	public String pass; // 4
	
	
	
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
		return (List<Funcoes>) roles;
	}
	public void setRoles(List<Funcoes> roles) {
		this.roles = roles;
	}
	public boolean isExpiracaoToken() {
		return expiracaoToken;
	}
	public void setExpiracaoToken(boolean expiracaoToken) {
		this.expiracaoToken = expiracaoToken;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	
}
