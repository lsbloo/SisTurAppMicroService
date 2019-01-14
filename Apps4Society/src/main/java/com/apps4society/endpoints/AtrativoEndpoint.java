package com.apps4society.endpoints;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.model.AtrativoTuristico;
import com.apps4society.model.Municipios;
import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.services.AtrativoService;
import com.apps4society.utilidades.Contador;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Atrativos")
@Transactional
@RestController
@RequestMapping("/sisturinfo/endpoints/atrativo")
public class AtrativoEndpoint{
	
	
	/**
	 * AtrativoService;
	 */
	private final AtrativoService atrativoService;
	
	@Autowired
	public AtrativoEndpoint(AtrativoService atrativoService) {
		this.atrativoService=atrativoService;
	}
	
	
	@ApiOperation(value="Returns all the Tourist Attractions that are available in the database")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/list")
	protected List<AtrativoTuristico> getAtratativoTuristico() throws InterruptedException {
		return this.atrativoService.findAllAtrativosActived();
	}
	
	
	@ApiOperation(value="Search for a tourist attraction specified by the Identifier")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/search/{identifier}")
	protected AtrativoTuristico getAtratativoTuristico(@PathVariable Long identifier) {
		return this.atrativoService.findAtrativoById(identifier);
	}
	
	
	@ApiOperation(value="Delete a tourist attraction specified by the Identifier")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/delete/{identifier}")
	protected void deleteAtratativoTuristico(@PathVariable Long identifier) {
		this.atrativoService.deleteAtrativo(identifier);
	}


}
