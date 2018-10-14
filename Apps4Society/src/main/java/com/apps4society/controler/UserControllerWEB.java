package com.apps4society.controler;

import java.util.List;
import java.util.Arrays;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.apps4society.annotations.AutenticadoUser;
import com.apps4society.model.User;
import com.apps4society.repository.FuncoesRepository;
import com.apps4society.repository.UserRepository;

@Controller
@Transactional
public class UserControllerWEB {
	
	@Autowired
	private UserRepository c;
	@Autowired
	private FuncoesRepository funcoesRepository;
	
	protected final String ROLE_USER="ROLE_USER";
	
	
	
	
	@GetMapping(value="useredit/{id}")
	public ModelAndView editClient(@PathVariable Long id){
		ModelAndView view = new ModelAndView("eventos/editUser");
		view.addObject("user",c.getUserId(id));
		
		return view;
		
	}
	@PostMapping(value="useredit/{id}")
	public String editClientpost(@PathVariable Long id,@AutenticadoUser @Valid @ModelAttribute User user, BindingResult result) {
		if(result.hasErrors()) {
			return "fragments/error.html";
		}
		
		
		c.editUser(user.isActived(), user.getLogin(), user.getNome(), user.getPass(), user.getEmail(), id);
		
		
		return "redirect:/listUsers";
	}
	
	@GetMapping(value="/userdel/{id}")
	public String deleteUser(@PathVariable Long id) {
		c.desativeUser(id);
		return "redirect:/listUsers";
	}
	
	@GetMapping(value="/listUsers")
	public ModelAndView getUsuarios() {
		ModelAndView obj = new ModelAndView("eventos/users_dash");
		
		Iterable<User> r = c.findAll();
		obj.addObject("users",r);
		
		return obj;
	}
	@RequestMapping(value="/userADD",method=RequestMethod.GET)
	public String createUsuarioGET(User user) {
		return "eventos/caduser";
	}
	
	@RequestMapping(value="/userADD",method=RequestMethod.POST)
	public String createUsuario(@AutenticadoUser @Valid @ModelAttribute User user,BindingResult result) {
	
		if(result.hasErrors()) {
			return createUsuarioGET(user);
		}
		List<User> list = (List<User>) c.checkExist(user.getLogin());
		if(list.size()>1) {
			System.out.println("Usuario ja Existe!");
			return "index";
		}else{
			String pass = user.getPass();
			//System.out.println("SENHA FODA!"+pass);
			//System.out.println("Login"+user.getLogin());
			//System.out.println(user.getNome());
			//System.out.println(user.getEmail());
			user.setRoles(Arrays.asList(funcoesRepository.findByName(ROLE_USER)));
			user.setPass(new BCryptPasswordEncoder().encode(pass)); 
			user.setActived(true);
			c.save(user);
			return "redirect:/";
		}
		
		
		
	}
	

}
