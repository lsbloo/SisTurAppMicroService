package com.apps4society.controler;

import com.apps4society.repository.AtrativoTuristicoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apps4society.model.AtratativoTuristico;



@Controller
public class AtrativoTuristicoControlerWeb {
	
	@Autowired
	private AtrativoTuristicoRepository atRepository;
	
	
	
	@RequestMapping(value="/listarAtrativos",method=RequestMethod.GET)
	public ModelAndView listarAtrativos() {
		ModelAndView mv = new ModelAndView("eventos/listarAtrativosTuristicos");
		Iterable<AtratativoTuristico> ats = atRepository.findAll();
		
		mv.addObject("atrativos",ats);
		return mv;
	}

}
