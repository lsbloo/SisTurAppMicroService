package com.apps4society.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.repository.AreaInteresseRepository;

@Controller
public class AreaInteresseController {
	
	/*
	 * Cadastra areas de interesse Turistico
	 * Exemplo> Litoral Norte
	 * 
	 */
	
	@Autowired
	private AreaInteresseRepository areaInteresseRepository;

	
	@RequestMapping(value="/cadastrarAreaTuristica",method=RequestMethod.GET)
	public String getCadastrar() {
		return "eventos/cadastrarAreaTuristica";
	}
	@RequestMapping(value="/cadastrarAreaTuristica",method=RequestMethod.POST)
	public void cadastrarAreaTuristica(AreaDeInteresseTuristico area) {
		/*
		 * Salva uma area de interesse 
		 * que contem um nome e uma descrição;
		 */
		areaInteresseRepository.save(area);
	}
	
	
}
