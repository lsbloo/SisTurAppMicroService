package com.apps4society.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="municipios")
public class Municipios {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	
	
	private String nome;
	private int populacao;
	private int latitude;
	private int longitude;
	private String estado;
	private String site;
	
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	
	public Municipios() {}

}
