package com.apps4society.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;


@Entity
public class AreaDeInteresseTuristico implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;

	
	
	@NotNull
	private String nomeAreaTuristica;
	
	@NotNull
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
	
}
