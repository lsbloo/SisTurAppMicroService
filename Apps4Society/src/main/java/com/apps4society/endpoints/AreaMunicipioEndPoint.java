package com.apps4society.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
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

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/endpointAreaMunicipio")
public class AreaMunicipioEndPoint  implements OperationFactory{

	
	/*
	 * Injetando o service; no EndPoint;
	 */
	@Autowired
	protected areaMunicipioService myservice;
	
	

	@ApiOperation(value="Retorna todos os municipios de uma area de Interesse")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping(value="/listarMunicipiosPorArea/{id}")
	public List<AreaMunicipio> listAreaMunicipio(@PathVariable("id") Long id){
		return (List<AreaMunicipio>) myservice.searchAllMunicipiosArea(id);
	}
	
	

	@Override
	public void sleep(String method) throws InterruptedException {
		// TODO Auto-generated method stub
		
	}


	
	
}
