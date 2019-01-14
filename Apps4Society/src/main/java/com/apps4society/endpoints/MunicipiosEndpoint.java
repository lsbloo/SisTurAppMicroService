package com.apps4society.endpoints;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.model.Municipios;
import com.apps4society.model.User;
import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.repository.UserRepository;
import com.apps4society.services.MunicipioService;
import com.apps4society.utilidades.Contador;
import com.apps4society.model.AtrativoTuristico;
import java.util.ArrayList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="API REST Municipios")
@Transactional
@RestController
@RequestMapping("/sisturinfo/endpoints/municipios")
public class MunicipiosEndpoint {
	

	/**
	 * MunicipioService
	 */
	private final MunicipioService municipioService;
	
	@Autowired
	public MunicipiosEndpoint(MunicipioService municipioService) {
		this.municipioService=municipioService;
	}
	
	@ApiOperation(value="Returns all the municipalities that are enabled in the system")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/list")
	protected List<Municipios> getMunicipios() throws InterruptedException {
		return this.municipioService.findAllMunicipiosActived();
	}
	
	@ApiOperation(value="Search for a city by specific Identifier")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/search/{identifier}")
	public Municipios getMunicipio(@PathVariable Long identifier) {
		return this.municipioService.getMunicipioById(identifier);
	}
	
	@ApiOperation(value="Delete a city by specific Identifier")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@RequestMapping(value="/delete/{identifier}",method=RequestMethod.GET)
	public void deleteMunicipio(@PathVariable Long identifier) {
		this.municipioService.deleteById(identifier);
	}
}
