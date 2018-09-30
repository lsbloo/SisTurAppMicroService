package com.apps4society.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.model.AtratativoTuristico;
import com.apps4society.model.Municipios;
import com.apps4society.repository.AtrativoTuristicoRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Atrativos")
@RestController
public class AtrativoTuristicoControler {
	
	@Autowired
	AtrativoTuristicoRepository r;
	
	@ApiOperation(value="Retorna todos os Atrativos Turisticos Cadastrados")
	@GetMapping("/rest_atrativosTuristicos")
	public List<AtratativoTuristico> getAtratativoTuristico() {
		return r.findAll();
	}
	
	@ApiOperation(value="Procura um atrativo especifico pelo ID")
	@GetMapping("/rest_atrativoTuristicoSearch/{id}")
	public Optional<AtratativoTuristico> getAtratativoTuristico(@PathVariable Long id) {
		/*OK
		 * Procura um atratativoTuristico especifico pelo ID
		 */
		return r.findById(id);
	}
	@ApiOperation(value="Deleta um atrativo especifico pelo ID")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value="/del_rest_atrativoTuristicodel/{id}",method=RequestMethod.GET)
	public boolean deleteAtratativoTuristico(@PathVariable Long id) {
		/* requisao do metodo = DELETE;
		 * DELETA UM atratativoTuristico PELO SEU ID
		 */
		r.deleteById(id);
		return true;
	}

}
