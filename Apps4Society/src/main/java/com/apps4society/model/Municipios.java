package com.apps4society.model;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
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
public class Municipios  implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	public long id;
	
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
	
	
	@Column(name="actived")
	public boolean actived;
	
	@Column(name="date")
	@CreationTimestamp
	public Date date; // 0
	

	@Column(name="imgUrl")
	public String imgUrl; // 1
	
		
	@Column(name="codValidacao")
	public String codValidacao; // 2
	
	
	@NotBlank
	@Column(name="nome_cidade")
	public String nome_cidade; // 3
	

	
	@Column(name="descricao")
	public String descricao; // 4

	@Column(name="areaTerritorial")
	public String areaTerritorial; // 5
	
	@NotNull
	@Column(name="latitude")
	public double latitude; // 6

	@NotNull
	@Column(name="longitude")
	public double longitude; // 7

	@NotBlank
	@Column(name="estado")
	public String estado; // 8

	@Column(name="populacao")
	public int populacao; // 9 

	@Column(name="site")
	public String site; // 10
	
	@Column(name="informacoesRelevantes")
	public String informacoesRelevantes; // 11

	@Column(name="email_responsavel_preenchimento")
	public String email_responsavel_preenchimento; // 12
	
	@Column(name="nome_responsavel_preenchimento")
	public String nome_responsavel_preenchimento; // 13
	
	@Column(name="contatos_responsavel_preenchimento")
	public String contatos_responsavel_preenchimento; // 14
	
	@Column(name="fonte_informacoes")
	public String fonte_informacoes; // 15
	
	
	
	
	public void setDate(Date date) {
		this.date=date;
	}
	
	public Date getDate() {
		return date;
	}
	private String cep;
	
	public void setCep(String cep) {
		this.cep=cep;
	}
	public String getCep() {
		return cep;
	}
	
	
	public String getNome_cidade() {
		return nome_cidade;
	}
	public void setNome_cidade(String nome_cidade) {
		this.nome_cidade = nome_cidade;
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
	
	public Municipios() {
		
	}
	
	
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
	public String getEmail_responsavel_preenchimento() {
		return email_responsavel_preenchimento;
	}
	public void setEmail_responsavel_preenchimento(String email_responsavel) {
		this.email_responsavel_preenchimento = email_responsavel;
	}
	public String getNome_responsavel_preenchimento() {
		return nome_responsavel_preenchimento;
	}
	public void setNome_responsavel_preenchimento(String nome_responsavel) {
		this.nome_responsavel_preenchimento = nome_responsavel;
	}
	public String getFonte_informacoes() {
		return fonte_informacoes;
	}
	public void setFonte_informacoes(String fonte_informacoes) {
		this.fonte_informacoes = fonte_informacoes;
	}
	public String getContatos_responsavel_preenchimento() {
		return contatos_responsavel_preenchimento;
	}
	public void setContatos_responsavel_preenchimento(String contatos_responsavel) {
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
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public Collection<AreaMunicipio> getAreaMunicipioList() {
		return areaMunicipioList;
	}
	public void setAreaMunicipioList(Collection<AreaMunicipio> areaMunicipioList) {
		this.areaMunicipioList = areaMunicipioList;
	}

}
