package com.apps4society.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="praias")
public class Praia{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	
	public void setId(long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	private boolean perigoTubarao;
	private boolean propiaBanho;
	private String tipoOrla;
	private static final String TIPO_MAR_ABERTO="";
	private static final String TIPO_PEQUENAS_ONDAS="";
	private static final String TIPO_ONDAS_FORTES="";
	
	
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


	public Praia() {}
	

}
