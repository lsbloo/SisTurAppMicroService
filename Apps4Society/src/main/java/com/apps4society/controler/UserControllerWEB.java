package com.apps4society.controler;

import java.util.List;
import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apps4society.annotations.AutenticadoUser;
import com.apps4society.model.User;
import com.apps4society.repository.FuncoesRepository;
import com.apps4society.repository.UserRepository;

@Controller
public class UserControllerWEB {
	
	@Autowired
	private UserRepository c;
	@Autowired
	private FuncoesRepository funcoesRepository;
	
	protected final String ROLE_USER="ROLE_USER";
	
	@RequestMapping(value="/userADD",method=RequestMethod.GET)
	public String createUsuarioGET() {
		return "eventos/caduser";
	}
	
	@RequestMapping(value="/userADD",method=RequestMethod.POST)
	public String createUsuario(@AutenticadoUser @Valid @ModelAttribute User user,BindingResult result) {
	
		if(result.hasErrors()) {
			return "fragments/error";
		}
		List<User> list = (List<User>) c.checkExist(user.getLogin());
		if(list.size()>1) {
			System.out.println("Usuario ja Existe!");
			return "index";
		}else{
			String pass = user.getPass();
			System.out.println("SENHA FODA!"+pass);
			System.out.println("Login"+user.getLogin());
			System.out.println(user.getNome());
			System.out.println(user.getEmail());
			user.setRoles(Arrays.asList(funcoesRepository.findByName(ROLE_USER)));
			user.setPass(new BCryptPasswordEncoder().encode(pass)); 
			user.setActived(true);
			c.save(user);
			return "index";
		}
		
		
		
	}
	

}
