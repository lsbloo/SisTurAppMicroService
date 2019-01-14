package com.apps4society.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps4society.exceptions.ValidatorNullPointer;
import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.model.AreaMunicipio;
import com.apps4society.model.Municipios;
import com.apps4society.repository.AreaInteresseRepository;
import com.apps4society.repository.AreaMunicipioRepository;
import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.rolesmoldes.AmService;

@Service
@Transactional
public class AreaMunicipioService implements AmService{
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
	 * atrativoRepository
	 */
	@Autowired
	protected AtrativoTuristicoRepository atrativoRepository;
	
	
	/*
	 * Construtor Padrão!
	 */
	
	@Autowired
	public AreaMunicipioService(AreaMunicipioRepository areaMunicipioRepository, AreaInteresseRepository areaInteresseRepository,
			MunicipioRepository municipioRepository) {
		this.areaInteresseRepository=areaInteresseRepository;
		this.areaMunicipioRepository=areaMunicipioRepository;
		this.municipioRepository=municipioRepository;
		
	}


	@Override
	public List<Municipios> searchMunicipio(String namemunicipio) throws ValidatorNullPointer{
		// TODO Auto-generated method stub
		List<Municipios> mun = municipioRepository.checkExist(namemunicipio);	
			return mun;
	}


	@Override
	public List<AreaDeInteresseTuristico> searchAreaInteresse(String nameAreaInteresse)throws ValidatorNullPointer {
		// TODO Auto-generated method stub
		List<AreaDeInteresseTuristico> areaInter = areaInteresseRepository.searchAreaName(nameAreaInteresse);
		return areaInter;
	}
	
	@Override
	public AreaMunicipio searchAreaMunicipio(Long municipioId, Long AreaInteresseId) throws ValidatorNullPointer {
		// TODO Auto-generated method stub
		AreaMunicipio list_area_mun = areaMunicipioRepository.searchAreaMun(municipioId,AreaInteresseId);
	
		return list_area_mun;
			
	}


	@Override
	public List<AreaMunicipio> searchAllMunicipiosArea(Long id_area_interesse) throws ValidatorNullPointer{
		// TODO Auto-generated method stub
		List<AreaMunicipio> list_area_mun = (List<AreaMunicipio>) areaMunicipioRepository.SearchMunArea(id_area_interesse);
		return list_area_mun;
		
	}

}

