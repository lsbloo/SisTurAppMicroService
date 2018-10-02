package com.apps4society.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import java.util.List;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name="municipios")

public class Municipios implements Serializable{
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	public void setId(long id) {
		this.id=id;
	}
	public long getId() {
		return id;
	}
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="areaMunicipio",joinColumns= {@JoinColumn(name="municipio_id",referencedColumnName="id")},
	inverseJoinColumns= {@JoinColumn(name="area_id",referencedColumnName="id")})
	private Collection<AreaMunicipio> areaMunicipioList;
	
	
	@NotNull
	
	private String date; // 0
	
	@NotNull
	
	private String imgUrl; // 1
	
	@NotNull
	

	private String codValidacao; // 2
	
	@NotNull

	
	private String nome_cidade; // 3
	
	@NotNull
	

	private String descricao; // 4
	@NotNull
	
	
	
	private String areaTerritorial; // 5
	
	@NotNull
	private double latitude; // 6
	@NotNull
	private double longitude; // 7
	@NotNull
	
	private String estado; // 8
	@NotNull
	
	private int populacao; // 9 
	@NotNull
	
	private String site; // 10
	@NotNull
	
	private String informacoesRelevantes; // 11
	@NotNull
	
	private String email_responsavel_preenchimento; // 12
	@NotNull
	
	private String nome_responsavel_preenchimento; // 13
	@NotNull
	
	private String contatos_responsavel_preenchimento; // 14
	@NotNull
	
	private String fonte_informacoes; // 15
	
	
	
	
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
	public String getImgUrl() {
		return imgUrl;
	}
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	public String getCodValidacao() {
		return codValidacao;
	}
	public void setCodValidacao(String codValidacao) {
		this.codValidacao = codValidacao;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
