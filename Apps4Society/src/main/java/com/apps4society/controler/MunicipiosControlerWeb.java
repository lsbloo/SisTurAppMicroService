package com.apps4society.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apps4society.model.Municipios;
import com.apps4society.repository.MunicipioRepository;

@Controller
public class MunicipiosControlerWeb {
	
	@Autowired
	private MunicipioRepository cityRepository;
	
	
	
	
	@RequestMapping(value="/listarMunicipios",method=RequestMethod.GET)
	public ModelAndView listCity() {
		ModelAndView mv = new ModelAndView("eventos/listarMunicipios");
		Iterable<Municipios> citys = cityRepository.findAll();
		System.out.println(citys);
		mv.addObject("municipios",citys);
		return mv;
		
	}
	
	

}
