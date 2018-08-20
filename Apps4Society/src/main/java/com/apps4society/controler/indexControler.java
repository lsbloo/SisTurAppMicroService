package com.apps4society.controler;

import org.springframework.boot.origin.SystemEnvironmentOrigin;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class indexControler {
	
	@RequestMapping(value="/", method= RequestMethod.GET)	
	public String indexHTML() {
		System.out.println("oks.");
		return "index";
	}
	

	/*
	 *   @GetMapping("/home")
    public String home() {
        return "/home";
    }

    @GetMapping("/admin")
    public String admin() {
        return "/admin";
    }

    @GetMapping("/user")
    public String user() {
        return "/user";
    }
	 */
    @RequestMapping(value="/login",method=RequestMethod.GET)
    public String login() {

        return "/fragments/login";
    }
    @RequestMapping(value="/login",method=RequestMethod.POST)
    public String loginSucess() {
    	System.err.println("ta de brinkjs!");
    	return "eventos/dashboarduser";
    }

 

}
