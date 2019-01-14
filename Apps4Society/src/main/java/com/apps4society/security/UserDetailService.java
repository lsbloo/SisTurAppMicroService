package com.apps4society.security;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.apps4society.model.Functions;
import com.apps4society.model.Privilege;
import com.apps4society.repository.FunctionRepository;
import com.apps4society.repository.UserRepository;
import com.apps4society.services.UserService;

@Repository
@Transactional
public class UserDetailService implements UserDetailsService{

	/**
	 * UserService
	 */
	private final UserService userService;
	
	
	@Autowired
	public UserDetailService(UserService userService) {
		this.userService = userService;
	}
	
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.apps4society.model.User u = this.userService.findByLogin(login);
		try {
			if(u==null) {
				
				return new User(" "," ",true,true,true,true,getAuthorities(Arrays.asList(this.userService.getFunctionByName("ROLE_USER"))));
				
			}
			
		}catch(InternalAuthenticationServiceException e) {
			senhaErrada();
		}
		
	
		return new User(
				
		          u.getEmail(), u.getPass(), u.isActived(), true, true, 
		          true, getAuthorities(u.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(
		      Collection<Functions> roles) {
		  
				
		        return getGrantedAuthorities(getPrivileges(roles));
		    }
		 
		    private List<String> getPrivileges(Collection<Functions> roles) {
		    	
		  
		        List<String> privileges = new ArrayList<>();
		       
		        List<String> collection = new ArrayList<>();
		      
		        for (Functions role : roles) {
		        	
		            collection.add(role.getAuthority());
		        }
		        if(collection!=null) {
		        	
		        	
		        	for(int i =0 ; i<collection.size();i++) {
		        		
		        		privileges.add(collection.get(i));
		        	}
		        	
		        }
		        return privileges;
		        
		    }
		    private List<GrantedAuthority> getGrantedAuthorities(List<String> privileges) {
		    
		        List<GrantedAuthority> authorities = new ArrayList<>();
		        for (String privilege : privileges) {
		            authorities.add(new SimpleGrantedAuthority(privilege));
		        }
		      
		        return authorities;
		    }
	public String senhaErrada() {
		return "eventos/senhaErrada";
	}

}
