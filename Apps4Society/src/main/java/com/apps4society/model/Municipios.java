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
	
	private String date; // 0
	private String nome_cidade; // 1
	private String descricao; // 2
	private String areaTerritorial; // 3
	private double latitude; // 4
	private double longitude; // 5
	private String estado; // 6
	private int populacao; // 7 
	private String site; // 8
	private String informacoesRelevantes; // 9
	private String email_responsavel_preenchimento; // 10
	private String nome_responsavel_preenchimento; // 11
	private String contatos_responsavel_preenchimento; // 12
	private String fonte_informacoes; // 13
	
	
	
	
	public void setDate(String date) {
		this.date=date;
	}
	
	public String getDate() {
		return date;
	}
	private String cep;
	
	public void setCep(String cep) {
		this.cep=cep;
	}
	public String getCep() {
		return cep;
	}
	
	
	public String getNomecidade() {
		return nome_cidade;
	}
	public void setNomecidade(String nome) {
		this.nome_cidade = nome;
	}
	public int getPopulacao() {
		return populacao;
	}
	public void setPopulacao(int populacao) {
		this.populacao = populacao;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
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
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	
	public Municipios() {}
	public String getAreaTerritorial() {
		return areaTerritorial;
	}
	public void setAreaTerritorial(String areaTerritorial) {
		this.areaTerritorial = areaTerritorial;
	}
	public String getInformacoesRelevantes() {
		return informacoesRelevantes;
	}
	public void setInformacoesRelevantes(String informacoesRelevantes) {
		this.informacoesRelevantes = informacoesRelevantes;
	}
	public String getEmail_responsavel() {
		return email_responsavel_preenchimento;
	}
	public void setEmail_responsavel(String email_responsavel) {
		this.email_responsavel_preenchimento = email_responsavel;
	}
	public String getNome_responsavel() {
		return nome_responsavel_preenchimento;
	}
	public void setNome_responsavel(String nome_responsavel) {
		this.nome_responsavel_preenchimento = nome_responsavel;
	}
	public String getFonte_informacoes() {
		return fonte_informacoes;
	}
	public void setFonte_informacoes(String fonte_informacoes) {
		this.fonte_informacoes = fonte_informacoes;
	}
	public String getContatos_responsavel() {
		return contatos_responsavel_preenchimento;
	}
	public void setContatos_responsavel(String contatos_responsavel) {
		this.contatos_responsavel_preenchimento = contatos_responsavel;
	}

}
