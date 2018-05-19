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
import com.apps4society.model.Praia;
import com.apps4society.repository.PraiaRepository;

@RestController
public class Praia_controler {
	
	@Autowired
	PraiaRepository repo;
	
	@GetMapping("/praias")
	public List<Praia> getPraia() {
		return repo.findAll();
	}
	
	@GetMapping("/praiasSearch/{id}")
	public Optional<Praia> getPraias(@PathVariable Long id) {
		/*OK
		 * Procura um atratativoTuristico especifico pelo ID
		 */
		return repo.findById(id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/praias/{id}")
	public boolean deletePraias(@PathVariable Long id) {
		/* requisao do metodo = DELETE;
		 * DELETA UMA PRAIA  PELO SEU ID
		 */
		repo.deleteById(id);
		return true;
	}

}
