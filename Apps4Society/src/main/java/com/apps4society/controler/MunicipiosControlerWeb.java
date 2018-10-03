package com.apps4society.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apps4society.model.Municipios;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.utilidades.MyCalendar;

@Controller
public class MunicipiosControlerWeb {
	
	@Autowired
	private MunicipioRepository cityRepository;
	
	private MyCalendar mycalendar;
	
	
	
	
	@RequestMapping(value="/listarMunicipios",method=RequestMethod.GET)
	public ModelAndView listCity() {
		ModelAndView mv = new ModelAndView("eventos/listarMunicipios");
		Iterable<Municipios> citys = cityRepository.findAll();
		System.out.println(citys);
		mv.addObject("municipios",citys);
		return mv;
		
	}
	
	@RequestMapping(value="/cadastrarMunicipio",method=RequestMethod.GET)
	public String cadMun() {
		return "eventos/cadcity";
	}
	
	@RequestMapping(value="/cadastrarMunicipio",method=RequestMethod.POST)
	public String cadMunpost(@ModelAttribute Municipios mun, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "fragments/error";
		}
		mycalendar = new MyCalendar();
		System.err.println("XDXD lala" + mun.getNomecidade());
		mun.setDate(mycalendar.returnData());
		
		cityRepository.save(mun);
		
		return "eventos/painel_user";
		
	}
	

}
