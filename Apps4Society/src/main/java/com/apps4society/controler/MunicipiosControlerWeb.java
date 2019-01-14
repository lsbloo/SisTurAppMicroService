package com.apps4society.controler;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.apps4society.services.MunicipioService;


@Controller
@RequestMapping("/sisturinfo/municipios")
public class MunicipiosControlerWeb {
	
	private final MunicipioService municipioService;
	
	@Autowired
	public MunicipiosControlerWeb(MunicipioService municipioService) {
		this.municipioService=municipioService;
	}
	
	
	@GetMapping("/edit/{indentifier}")
	public ModelAndView enterEdit(@PathVariable Long identifier) {
		ModelAndView v=null;
		return v;
		
	}
	
	@GetMapping("/delete/{indentifier}")
	public ModelAndView enterDelete(@PathVariable Long identifier) {
		ModelAndView v=null;
		return v;
		
	}
}
