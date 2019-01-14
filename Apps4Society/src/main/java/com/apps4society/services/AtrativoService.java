package com.apps4society.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.model.AtrativoTuristico;
@Service
@Transactional
public class AtrativoService {
	
	/**
	 * AtrativoRepository
	 */
	
	private final AtrativoTuristicoRepository atratativoRepository;
	
	@Autowired
	public AtrativoService(AtrativoTuristicoRepository atratativoRepository) {
		this.atratativoRepository=atratativoRepository;
	}

	
	public List<AtrativoTuristico> findAllAtrativosActived(){
		return this.atratativoRepository.findAllActived();
	}
	
	public AtrativoTuristico findAtrativoById(Long id) {
		return this.atratativoRepository.findByIdActived(id);
	}
	
	public void deleteAtrativo(Long id) {
		this.atratativoRepository.desative(id);
	}
	
}
