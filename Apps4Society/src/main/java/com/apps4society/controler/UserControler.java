package com.apps4society.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.apps4society.repository.UserRepository;
import com.apps4society.model.User;


@Controller
public class UserControler {
	private static Map<Integer,User> users;
	private static BCryptPasswordEncoder encoder;
	
	@Autowired
	private UserRepository c;
	
	@RequestMapping(value="/users",method=RequestMethod.GET)
	public List<User> getUser() {
		return (List<User>) c.findAll();
	}
	
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
		user.setPass(new BCryptPasswordEncoder().encode(pass)); 
		c.save(user);
		return "index";
	}
	
	@GetMapping("/user/{id}")
	public Optional<User> getCliente(@PathVariable Long id) {
		return c.findById(id);
	}
	@DeleteMapping("/userdel/{id}")
	public boolean deleteUser(@PathVariable Long id) {
		c.deleteById(id);
		return true;
	}
	@PostMapping("/useradd")
	public User createCliente(@RequestBody User user) {
		user.setNome("osvaldo");
		//user.setSobrenome("airon");
		return c.save(user);
	}
	@PutMapping("/user")
	public User updateCliente(@RequestBody User user) {
		return c.save(user);
	}
	@GetMapping("/hello")
	  public User hello() {
	    final User person = new User();
	    person.setNome("John");
	    return person;
	  }
	
	@RequestMapping(value="/usuarios", method = RequestMethod.GET)
	public ResponseEntity<List<User>> openCSV() throws IOException{
		User user = new User();
		 users = new HashMap<Integer,User>();
		user.setNome("osvaldo");
		//user.setSobrenome("airon");
		users.put(1, user);

		return new ResponseEntity<List<User>>(new ArrayList<User>(users.values()), HttpStatus.OK);
		
	}
	
	
}

