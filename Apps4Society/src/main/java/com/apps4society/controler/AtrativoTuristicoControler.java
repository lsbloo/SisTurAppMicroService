package com.apps4society.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
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
	
	@GetMapping("/atrativoTuristicoSearch/{id}")
	public Optional<AtratativoTuristico> getAtratativoTuristico(@PathVariable Long id) {
		/*OK
		 * Procura um atratativoTuristico especifico pelo ID
		 */
		return r.findById(id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/atrativoTuristicodel/{id}")
	public boolean deleteAtratativoTuristico(@PathVariable Long id) {
		/* requisao do metodo = DELETE;
		 * DELETA UM atratativoTuristico PELO SEU ID
		 */
		r.deleteById(id);
		return true;
	}

}
