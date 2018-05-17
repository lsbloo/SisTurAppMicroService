package com.apps4society.controler;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	public List<Municipios> getUser() {
		return m.findAll();
	}

}
