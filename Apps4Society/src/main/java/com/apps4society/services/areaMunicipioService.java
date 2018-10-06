package com.apps4society.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps4society.repository.AreaInteresseRepository;
import com.apps4society.repository.AreaMunicipioRepository;
import com.apps4society.repository.MunicipioRepository;

@Service
@Transactional
public class areaMunicipioService {
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
	
	
	
	
}

