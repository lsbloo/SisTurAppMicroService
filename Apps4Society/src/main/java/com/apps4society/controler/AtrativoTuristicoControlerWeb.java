package com.apps4society.controler;

import com.apps4society.repository.AtrativoTuristicoRepository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apps4society.model.AtratativoTuristico;
import com.apps4society.utilidades.MyCalendar;


@Controller
public class AtrativoTuristicoControlerWeb {
	private MyCalendar dataCad;
	
	@Autowired
	private AtrativoTuristicoRepository atRepository;
	
	
	
	@RequestMapping(value="/listarAtrativos",method=RequestMethod.GET)
	public ModelAndView listarAtrativos() {
		ModelAndView mv = new ModelAndView("eventos/listarAtrativosTuristicos");
		Iterable<AtratativoTuristico> ats = atRepository.findAll();
		
		mv.addObject("atrativos",ats);
		return mv;
	}
	
	@RequestMapping(value="/cadAtrativos",method=RequestMethod.GET)
	public String cadAtRedirect() {
		return "eventos/cadAtrativo";
	}
	
	@RequestMapping(value="/cadAtrativos",method=RequestMethod.POST)
	public String cadAtrativo(AtratativoTuristico at) {
		
		try {
			
			
		}catch(Exception e) {
			
		}
		dataCad = new MyCalendar();
		
		at.setDate(dataCad.returnData());
		
		atRepository.save(at);
		System.err.println("Cadastrado!");
		return "cadastrado!";
	}
	

}
