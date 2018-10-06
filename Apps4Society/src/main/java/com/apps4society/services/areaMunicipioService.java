package com.apps4society.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.model.AreaMunicipio;
import com.apps4society.model.Municipios;
import com.apps4society.repository.AreaInteresseRepository;
import com.apps4society.repository.AreaMunicipioRepository;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.rolesmoldes.AmService;

@Service
@Transactional
public class areaMunicipioService implements AmService{
	/*
	 * Responsavel por realizar todas as operacoes de mapeamento(relacionamento) entre
	 * os repositorios injetados abaixo;
	 */

	/*
	 * areaMunicipioRepository
	 */
	@Autowired
	protected AreaMunicipioRepository areaMunicipioRepository;
	
	/*
	 * areaInteresseRepository
	 */
	@Autowired
	protected AreaInteresseRepository areaInteresseRepository;
	
	/*
	 * municipioRepository
	 */
	@Autowired
	protected MunicipioRepository municipioRepository;
	
	
	/*
	 * Construtor Padrão!
	 */
	
	@Autowired
	public areaMunicipioService(AreaMunicipioRepository areaMunicipioRepository, AreaInteresseRepository areaInteresseRepository,
			MunicipioRepository municipioRepository) {
		this.areaInteresseRepository=areaInteresseRepository;
		this.areaMunicipioRepository=areaMunicipioRepository;
		this.municipioRepository=municipioRepository;
		
	}


	@Override
	public List<Municipios> searchMunicipio(String namemunicipio) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<AreaDeInteresseTuristico> searchAreaInteresse(String nameAreaInteresse) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<AreaMunicipio> searchAreaMunicipio(String nameAreaMunicipio) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}

