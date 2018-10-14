package com.apps4society.controler;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apps4society.annotations.AutenticadoUser;
import com.apps4society.model.Municipios;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.utilidades.MyCalendar;

@Controller
public class MunicipiosControlerWeb {
	
	@Autowired
	private MunicipioRepository cityRepository;
	
	
	
	
	
	
	@GetMapping(value="municipiodel/{id}")
	public String municipiodel(@PathVariable Long id) {
		cityRepository.desableById(id);
		return "redirect:/listarMunicipios";
	}
	
	@GetMapping(value="municipioedit/{id}")
	public ModelAndView  municipioedit(@PathVariable Long id) {
		ModelAndView view = new ModelAndView("eventos/municipioedit");
		view.addObject("municipio",cityRepository.findByPraMim(id));
		return view;
	}
	
	@PostMapping(value="municipioedit/{id}")
	public String municipioeditpost(@PathVariable Long id, @AutenticadoUser @Valid @ModelAttribute Municipios mun,BindingResult result) {
		if(result.hasErrors()) {
			return "fragments/error";
		}
		cityRepository.updateMunicipio
		(
				mun.getNome_cidade(), 
				mun.getCodValidacao(), 
				mun.getAreaTerritorial(), 
				mun.getDescricao(), 
				mun.getEstado(), 
				mun.getEmail_responsavel_preenchimento(), 
				mun.getImgUrl(), 
				mun.getInformacoesRelevantes(), 
				mun.getLatitude(), 
				mun.getLongitude(), 
				mun.getNome_responsavel_preenchimento(), 
				mun.getPopulacao(), 
				mun.getSite(), 
				mun.getFonte_informacoes(), 
				mun.isActived(), 
				mun.getContatos_responsavel_preenchimento(), 
				id
		
				);
		
		return "redirect:/listarMunicipios";
		
	}
	
	
	@RequestMapping(value="/listarMunicipios",method=RequestMethod.GET)
	public ModelAndView listCity() {
		ModelAndView mv = new ModelAndView("eventos/listarMunicipios");
		List<Municipios> citys = cityRepository.findAll();
		System.out.println(citys.get(0).getNome_responsavel_preenchimento());
		mv.addObject("municipios",citys);
		return mv;
		
	}
	
	@RequestMapping(value="/cadastrarMunicipio",method=RequestMethod.GET)
	public String cadMun() {
		return "eventos/cadcity";
	}
	
	@RequestMapping(value="/cadastrarMunicipio",method=RequestMethod.POST)
	public String cadMunpost(@AutenticadoUser @Valid @ModelAttribute Municipios mun,BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "fragments/error.html";
		}
		System.out.println(mun.getNome_cidade());
		List<Municipios> list = cityRepository.checkExist(mun.getNome_cidade());
		if(list.size()>1) {
			System.err.println("Municipio Já ADD");
			/*
			 * SE JA EXISTIR UM MUNICIPIO RETORNA PRA UMA VIEW DIFERENTE
			 * coloquei index, mas dps troco
			 */
			return "index";
		}else {
			
			System.err.println("XDXD lala" + mun.getNome_cidade());
			
			mun.setActived(true);
			cityRepository.save(mun);
			return "eventos/painel_user";
		}
		
	}
	
	

}
