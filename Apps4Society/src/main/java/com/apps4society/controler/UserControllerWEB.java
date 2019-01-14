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

import com.apps4society.services.UserService;



@Controller
@RequestMapping("/sisturinfo/users")
public class UserControllerWEB {
	/**
	 * UserService
	 */
	private final UserService userService;
	
	
	@Autowired
	public UserControllerWEB(UserService userService) {
		this.userService=userService;
		
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
