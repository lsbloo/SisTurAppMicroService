
package com.apps4society.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps4society.repository.MunicipioRepository;
import com.apps4society.model.Municipios;

@Service
@Transactional
public class MunicipioService {
	
	
	/**
	 * Municipio Repository
	 */
	private final MunicipioRepository municipioRepository;
	
	
	@Autowired
	public MunicipioService(MunicipioRepository municipioRepository) {
		this.municipioRepository=municipioRepository;
	}
	
	public List<Municipios> findAllMunicipiosActived(){
		return this.municipioRepository.findAllByActived();
	}
	public void deleteById(Long id) {
		this.municipioRepository.desableById(id);
	}
	
	
	public Municipios getMunicipioById(Long id) {
		return this.municipioRepository.findActivedById(id);
	}
	
	
	public void updateMunicipio(Municipios municipio) {
		this.municipioRepository.updateMunicipio(
				municipio.getNome_cidade(), 
				municipio.getCodValidacao(), 
				municipio.getAreaTerritorial(), 
				municipio.getDescricao(), 
				municipio.getEstado(), 
				municipio.getEmail_responsavel_preenchimento(), 
				municipio.getImgUrl(), 
				municipio.getInformacoesRelevantes(), 
				municipio.getLatitude(), 
				municipio.getLongitude(), 
				municipio.getNome_responsavel_preenchimento(), 
				municipio.getPopulacao(), 
				municipio.getSite(), 
				municipio.getFonte_informacoes(), 
				municipio.isActived(), 
				municipio.getContatos_responsavel_preenchimento(), 
				municipio.getId());
	}
}

