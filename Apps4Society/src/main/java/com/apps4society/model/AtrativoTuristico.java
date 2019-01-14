package com.apps4society.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name="atrativosTuristicos")
public class AtrativoTuristico implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private long id;
	
	
	public void setId(long id) {
		this.id=id;
	}
	public Long getId() {
		return id;
	}
	
	@Column(name="actived")
	private boolean actived;

	@Column(name="date")
	private String date; // 0
	
	@Column(name="imgURL", length=1024)	
	private String imgURL; // 1
	

	@Column(name="codValidacao", length=1024)
	private String codValidacao; // 2
	
	
	@Column(name="nome_atrativo", length=1024)
	private String nome_atrativo; // 3
	
	
	@Column(name="comoChegar", length=1024)
	private String comoChegar; // 4
	
	@Column(name="descricao", length=1024)
	private String descricao; // 5
	@Column(name="infoContato", length=1024)
	private String infoContato; // 6
	
	@NotNull
	@Column(name="latitude", length=1024)
	private String latitude; // 7

	@NotNull
	@Column(name="longitude", length=1024)
	private String longitude; // 8 
	
	@Column(name="site", length=1024)
	private String site; // 9
	
	@NotBlank
	@Column(name="cidade")
	private String cidade; // 10
	
	@NotBlank
	@Column(name="link_maps", length=1024)
	private String link_maps;
	
	
	
	@NotBlank
	@Column(name="estado")
	private String estado; // 11
	

	@Column(name="informacoes_relevantes", length=1024)
	private String informacoes_relevantes; // 12

	@Column(name="email_responsavel_preenchimento")
	private String email_responsavel_preenchimento; // 13
	

	@Column(name="nome_responsavel_preenchimento")
	private String nome_responsavel_preenchimento; // 14
	
	
	@Column(name="contato_responsavel_preenchimento")
	private String contato_responsavel_preenchimento; // 15
	
	@Column(name="fonte_informacoes", length=1024)
	private String fonte_informacoes; // 16
	
	
	@Column(name="nome_responsavel_atrativo")
	private String nome_responsavel_atrativo; // 17
	

	@Column(name="contato_responsavel_atrativo")
	private String contato_responsavel_atrativo; // 18
	

	@Column(name="email_atrativo")
	private String email_atrativo; // 19
	
	
	
	public void setDate(String date) {
		this.date=date;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getNome() {
		return nome_atrativo;
	}
	public void setNome(String nome) {
		this.nome_atrativo = nome;
	}

	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
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
	

	public AtrativoTuristico() {
		
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getInformacoes_relevantes() {
		return informacoes_relevantes;
	}
	public void setInformacoes_relevantes(String informacoes_relevantes) {
		this.informacoes_relevantes = informacoes_relevantes;
	}
	public String getEmail_responsavel() {
		return email_responsavel_preenchimento;
	}
	public void setEmail_responsavel(String email_responsavel) {
		this.email_responsavel_preenchimento = email_responsavel;
	}
	public String getNome_responsavel_preenchimento() {
		return nome_responsavel_preenchimento;
	}
	public void setNome_responsavel_preenchimento(String nome_responsavel_preenchimento) {
		this.nome_responsavel_preenchimento = nome_responsavel_preenchimento;
	}
	public String getContato_responsavel_preenchimento() {
		return contato_responsavel_preenchimento;
	}
	public void setContato_responsavel_preenchimento(String contato_responsavel_preenchimento) {
		this.contato_responsavel_preenchimento = contato_responsavel_preenchimento;
	}
	public String getFonte_informacoes() {
		return fonte_informacoes;
	}
	public void setFonte_informacoes(String fonte_informacoes) {
		this.fonte_informacoes = fonte_informacoes;
	}
	public String getNome_responsavel_atrativo() {
		return nome_responsavel_atrativo;
	}
	public void setNome_responsavel_atrativo(String nome_responsavel_atrativo) {
		this.nome_responsavel_atrativo = nome_responsavel_atrativo;
	}
	public String getContato_responsavel_atrativo() {
		return contato_responsavel_atrativo;
	}
	public void setContato_responsavel_atrativo(String contato_responsavel_atrativo) {
		this.contato_responsavel_atrativo = contato_responsavel_atrativo;
	}
	public String getEmail_reponsavel_atrativo() {
		return email_atrativo;
	}
	public void setEmail_reponsavel_atrativo(String email_reponsavel_atrativo) {
		this.email_atrativo = email_reponsavel_atrativo;
	}
	public String getCodValidacao() {
		return codValidacao;
	}
	public void setCodValidacao(String codValidacao) {
		this.codValidacao = codValidacao;
	}
	public String getImgURL() {
		return imgURL;
	}
	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}
	public boolean isActived() {
		return actived;
	}
	public void setActived(boolean actived) {
		this.actived = actived;
	}
	public String getLink_maps() {
		return link_maps;
	}
	public void setLink_maps(String link_maps) {
		this.link_maps = link_maps;
	}
	

}
