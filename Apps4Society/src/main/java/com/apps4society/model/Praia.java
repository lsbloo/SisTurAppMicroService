package com.apps4society.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="praias")
public class Praia {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}

	private boolean perigoTubarao;
	private boolean propiaBanho;
	private String tipoOrla;
	private static final String TIPO_MAR_ABERTO="";
	private static final String TIPO_PEQUENAS_ONDAS="";
	private static final String TIPO_ONDAS_FORTES="";
	private String comochegar;
	private String descricao;
	private String info_contato;
	private double latitude;
	private double longitude;
	private String nome;
	
	
	
	public boolean isPerigoTubarao() {
		return perigoTubarao;
	}
	public void setPerigoTubarao(boolean perigoTubarao) {
		this.perigoTubarao = perigoTubarao;
	}


	public boolean isPropiaBanho() {
		return propiaBanho;
	}
	public void setPropiaBanho(boolean propiaBanho) {
		this.propiaBanho = propiaBanho;
	}
	public String getTipoOrla() {
		return tipoOrla;
	}
	public void setTipoOrla(String tipoOrla) {
		this.tipoOrla = tipoOrla;
	}
	public static String getTipoMarAberto() {
		return TIPO_MAR_ABERTO;
	}
	public static String getTipoPequenasOndas() {
		return TIPO_PEQUENAS_ONDAS;
	}
	public static String getTipoOndasFortes() {
		return TIPO_ONDAS_FORTES;
	}

	public String getComochegar() {
		return comochegar;
	}
	public void setComochegar(String comochegar) {
		this.comochegar = comochegar;
	}
	public String getInfo_contato() {
		return info_contato;
	}
	public void setInfo_contato(String info_contato) {
		this.info_contato = info_contato;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	

}
