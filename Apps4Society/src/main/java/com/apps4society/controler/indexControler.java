package com.apps4society.controler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexControler {
	
	@RequestMapping(value="/", method= RequestMethod.GET)	
	public String indexHTML() {
		//ModelAndView mv = new ModelAndView("index.html");
		System.out.println("oks.");
		return "index";
	}

}
