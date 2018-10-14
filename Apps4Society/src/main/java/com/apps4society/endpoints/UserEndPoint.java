package com.apps4society.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.apps4society.repository.FuncoesRepository;
import com.apps4society.repository.UserRepository;

import io.swagger.annotations.ApiOperation;

import com.apps4society.annotations.AutenticadoUser;
import com.apps4society.model.User;


@RestController
@Transactional
@RequestMapping("/endpointUsers")
public class UserEndPoint {
	private static Map<Integer,User> users;
	private static BCryptPasswordEncoder encoder;
	protected final String ROLE_USER="ROLE_USER";
	
	@Autowired
	private UserRepository c;
	@Autowired
	private FuncoesRepository funcoesRepository;
	
	@ApiOperation(value="Retorna todos os usuarios")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUser() {
		return (List<User>) c.findAll();
	}

	@ApiOperation(value="Retorna um usuario especifico pelo ID")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@GetMapping("/user/{id}")
	public Optional<User> getCliente(@PathVariable Long id) {
		return c.findById(id);
	}
	
	@ApiOperation(value="Desativa um usuario pelo seu ID")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value="/userdel/{id}",method=RequestMethod.GET)
	public boolean deleteUser(@PathVariable Long id) {
		c.desativeUser(id);
		return true;
	}
	
	@GetMapping("/hello")
	  public User hello() {
	    final User person = new User();
	    person.setNome("alala");
	    return person;
	  }
	
	@ApiOperation(value="Exibe o modelo de atributos de um objeto User")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value="/attrUser", method = RequestMethod.GET)
	public ResponseEntity<List<User>> openCSV() throws IOException{
		User user = new User();
		 users = new HashMap<Integer,User>();
		user.setNome("osvaldo");
		//user.setSobrenome("airon");
		users.put(1, user);

		return new ResponseEntity<List<User>>(new ArrayList<User>(users.values()), HttpStatus.OK);
		
	}
	
	@ApiOperation(value="Adiciona um usuário de acordo com seus atributos")
	@ResponseStatus(HttpStatus.ACCEPTED)
	@RequestMapping(value="/adicionarUsuarioAdmin",method=RequestMethod.POST)
	public String createUsuario(@AutenticadoUser @ModelAttribute @Valid User user,BindingResult result) {
	
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

