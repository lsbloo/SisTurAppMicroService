package com.apps4society.controler;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apps4society.model.User;
import com.apps4society.repository.FuncoesRepository;
import com.apps4society.repository.UserRepository;

@Controller
public class UserControllerWEB {
	
	@Autowired
	private UserRepository c;
	@Autowired
	private FuncoesRepository funcoesRepository;
	
	@RequestMapping(value="/userADD",method=RequestMethod.GET)
	public String createUsuarioGET() {
		return "/eventos/caduser";
	}
	
	@RequestMapping(value="/userADD",method=RequestMethod.POST)
	public String createUsuario(User user) {
	
		String pass = user.getPass();
		System.out.println("SENHA FODA!"+pass);
		System.out.println("Login"+user.getLogin());
		System.out.println(user.getNome());
		System.out.println(user.getEmail());
		user.setRoles(Arrays.asList(funcoesRepository.findByName("ROLE_USER")));
		user.setPass(new BCryptPasswordEncoder().encode(pass)); 
		c.save(user);
		return "index";
	}
	

}
