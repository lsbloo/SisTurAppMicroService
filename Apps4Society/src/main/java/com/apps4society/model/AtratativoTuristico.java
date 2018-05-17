package com.apps4society.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="atrativosTuristicos")
public class AtratativoTuristico {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	public void setId(long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	private String nome;
	private int latitude;
	private int longitude;
	private String comoChegar;
	private String site;
	private String infoContato;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getLatitude() {
		return latitude;
	}
	public void setLatitude(int latitude) {
		this.latitude = latitude;
	}

	public int getLongitude() {
		return longitude;
	}
	public void setLongitude(int longitude) {
		this.longitude = longitude;
	}
	public String getComoChegar() {
		return comoChegar;
	}
	public void setComoChegar(String comoChegar) {
		this.comoChegar = comoChegar;
	}
	public String getSite() {
		return site;
	}
	public void setSite(String site) {
		this.site = site;
	}
	public String getInfoContato() {
		return infoContato;
	}
	public void setInfoContato(String infoContato) {
		this.infoContato = infoContato;
	}

	public AtratativoTuristico() {}
	

}
