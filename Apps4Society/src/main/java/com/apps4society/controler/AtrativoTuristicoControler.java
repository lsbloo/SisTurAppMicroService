package com.apps4society.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.model.AtratativoTuristico;
import com.apps4society.model.Municipios;
import com.apps4society.repository.AtrativoTuristicoRepository;

@RestController
public class AtrativoTuristicoControler {
	
	@Autowired
	AtrativoTuristicoRepository r;
	
	@GetMapping("/atrativosTuristicos")
	public List<AtratativoTuristico> getAtratativoTuristico() {
		return r.findAll();
	}

}
