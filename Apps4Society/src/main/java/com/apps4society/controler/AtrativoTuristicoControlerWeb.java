package com.apps4society.controler;

import com.apps4society.services.AtrativoService;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.ModelAndView;




@Controller
@RequestMapping("/sisturinfo/atrativoturistico")
public class AtrativoTuristicoControlerWeb {
	
	
	/**
	 * AtrativoService
	 */
	private final AtrativoService atrativoService;
	
	
	@Autowired
	public AtrativoTuristicoControlerWeb(AtrativoService atrativoService) {
		this.atrativoService=atrativoService;
	}
	
	
	@GetMapping("/edit/{identifier}")
	public ModelAndView enterEdit(@PathVariable Integer identifier) {
		ModelAndView v=null;
		
		return v;
	}
	
	@GetMapping("/delete/{identifier}")
	public ModelAndView enterDelete(@PathVariable Integer identifier) {
		ModelAndView v=null;
		
		return v;
	}
	
	
}
