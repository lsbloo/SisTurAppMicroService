package com.apps4society.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.apps4society.repository.AreaMunicipioRepository;
import com.apps4society.model.AreaMunicipio;
import java.util.List;

@RestController
public class AreaMunicipioController {

	
	@Autowired
	private AreaMunicipioRepository areaMunicipioRepository;
	
	
	
	@RequestMapping(value="/listAreaMunicipio",method=RequestMethod.GET)
	public List<AreaMunicipio> listAreaMunicipio(){
		return areaMunicipioRepository.findAll();
	}
	
	
}
