package com.apps4society.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.repository.AreaInteresseRepository;
import com.apps4society.services.AtrativoService;

@Controller
public class AreaInteresseController {
	
	
	 
	/**
	 * AtrativoService
	 */
	private final AtrativoService atrativoService;
	
	@Autowired
	public AreaInteresseController(AtrativoService atrativoService) {
		this.atrativoService=atrativoService;
	}
}
