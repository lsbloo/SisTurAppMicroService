package com.apps4society.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.repository.AreaInteresseRepository;
import com.apps4society.repository.AreaMunicipioRepository;
import com.apps4society.model.AreaMunicipio;
import com.apps4society.model.Municipios;
import java.util.List;
import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.rolesmoldes.OperationFactory;

@RestController
public class AreaMunicipioEndPoint  implements OperationFactory{

	
	@Autowired
	protected AreaMunicipioRepository areaMunicipioRepository;
	@Autowired
	protected AreaInteresseRepository areaInteresseRepository;
	@Autowired
	protected MunicipioRepository municipioRepository;
	
	protected static List<AreaDeInteresseTuristico> list_area_turistica;
	protected static List<Municipios> list_municipios;
	
	
	@RequestMapping(value="/listAreaMunicipio",method=RequestMethod.GET)
	public List<AreaMunicipio> listAreaMunicipio(){
		return areaMunicipioRepository.findAll();
	}
	
	
	@RequestMapping(value="/aliments_areaMunicipio",method=RequestMethod.GET)
	public List<AreaDeInteresseTuristico> listAreaMunicipioRelacionado(){
		
		
		return null;
		
	}
	
	public void oks() {
		list_area_turistica = areaInteresseRepository.findAll();
		list_municipios = municipioRepository.findAll();
	}


	@Override
	public void validation(String method) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}


	
	
}
