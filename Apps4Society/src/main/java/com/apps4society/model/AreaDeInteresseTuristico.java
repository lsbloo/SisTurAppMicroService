package com.apps4society.model;

import java.io.Serializable;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class AreaDeInteresseTuristico implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;

	
	@OneToMany
	@JoinTable(name="areaMunicipio", joinColumns= {@JoinColumn(name="areaInteresse_id" , 
	referencedColumnName="id")},inverseJoinColumns= {@JoinColumn(name="area_id", 
	referencedColumnName="id")})
	private Collection<AreaMunicipio> areaInteresseList;

	
	
	@NotNull
	@Column(name="actived")
	private boolean actived;
	
	@NotBlank
	@Column(name="nomeAreaTuristica")
	private String nomeAreaTuristica;
	
	@NotBlank
	@Column(name="descricaoAreaTuristica")
	private String descricaoAreaTuristica;

	public String getNomeAreaTuristica() {
		return nomeAreaTuristica;
	}

	public void setNomeAreaTuristica(String nomeAreaTuristica) {
		this.nomeAreaTuristica = nomeAreaTuristica;
	}
	
	public void setDescricaoAreaTuristica(String descricaoArea) {
		this.descricaoAreaTuristica=descricaoArea;
	}
	public String getDescricaoAreaTuristica() {
		return descricaoAreaTuristica;
	}

	public boolean isActived() {
		return actived;
	}

	public void setActived(boolean actived) {
		this.actived = actived;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
}
