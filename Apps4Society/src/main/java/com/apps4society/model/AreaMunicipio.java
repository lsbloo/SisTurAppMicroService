package com.apps4society.model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

import java.util.Collection;
import java.util.List;
import com.apps4society.model.Municipios;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import com.apps4society.model.AreaDeInteresseTuristico;
@Entity
public class AreaMunicipio implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/*
	 * Cria a relaçao entre uma Area de Interesse Turistico e uma AreaMuncipio
	 * Um municipio pode conter diversos Atrativos
	 */

	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="native")
	@GenericGenerator(name="native",strategy="native")
	@Column(name="id")
	private long id;
	
	
	@OneToMany(cascade=CascadeType.ALL)
	@JoinTable(name="areaMunicipio",joinColumns= {@JoinColumn(name="area_id",referencedColumnName="id")},inverseJoinColumns= {@JoinColumn(name="municipio_id",referencedColumnName="id")})
	private Collection<Municipios> municipios;
	
	
	
	@Column(name="actived")
	@NotNull
	private boolean actived;



	public boolean isActived() {
		return actived;
	}



	public void setActived(boolean actived) {
		this.actived = actived;
	}
	
	
	

}
