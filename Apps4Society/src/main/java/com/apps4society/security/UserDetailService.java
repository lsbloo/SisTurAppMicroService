package com.apps4society.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.apps4society.model.User;
import com.apps4society.repository.UserRepository;

@Repository
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User u = repository.findByLogin(login);
		
		try {
			//User u = repository.findByLogin(login);
			if(u==null) {
				
				senhaErrada();
				
				throw new InternalAuthenticationServiceException("Usuario não encontrado!");
				
			}else {
				return u;
			}
			
		}catch(InternalAuthenticationServiceException e) {
			senhaErrada();
		}
		return u;
	}
	
	public String senhaErrada() {
		return "eventos/senhaErrada";
	}

}
