package com.apps4society.controler;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.model.Municipios;
import com.apps4society.model.User;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.repository.UserRepository;

@RestController
public class MunicipiosControler {
	
	@Autowired
	private MunicipioRepository m;
	
	@GetMapping("/municipios")
	public List<Municipios> getMunicipio() {
		/*OK
		 * Retorna toda a lista de municipios
		 */
		return m.findAll();
	}
	
	@GetMapping("/municipioSearch/{id}")
	public Optional<Municipios> getCliente(@PathVariable Long id) {
		/*OK
		 * Procura um municipio especifico pelo ID
		 */
		return m.findById(id);
	}
	
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@DeleteMapping("/municipiodel/{id}")
	public boolean deleteMunicipio(@PathVariable Long id) {
		/* requisao do metodo = DELETE;
		 * DELETA UM MUNICIPIO PELO SEU ID
		 */
		m.deleteById(id);
		return true;
	}
	//@PostMapping("/municipioadd")
	//public Municipios createMunicipio(@RequestBody Municipios city) {
		//return m.save(city);
//	}
	

}
