package com.apps4society.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.repository.AreaInteresseRepository;
import com.apps4society.repository.AreaMunicipioRepository;
import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.model.AreaMunicipio;
import com.apps4society.model.Municipios;
import java.util.List;
import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.rolesmoldes.OperationFactory;
import com.apps4society.services.areaMunicipioService;

@RestController
public class AreaMunicipioEndPoint  implements OperationFactory{

	
	@Autowired
	protected areaMunicipioService myservice;
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
	
	
	
	
	
	
	@GetMapping(value="/listAreaMunicipio")
	public List<AreaMunicipio> listAreaMunicipio(){
		
		return (List<AreaMunicipio>) myservice.searchAllAreas();
	}
	
	

	@Override
	public void sleep(String method) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}


	
	
}
