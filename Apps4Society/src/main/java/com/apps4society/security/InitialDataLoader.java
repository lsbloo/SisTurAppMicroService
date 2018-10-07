package com.apps4society.security;

import java.util.Arrays;
import java.util.Collection;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.stereotype.Component;

import com.apps4society.model.Funcoes;
import com.apps4society.model.Privilege;
import com.apps4society.model.User;
import com.apps4society.repository.FuncoesRepository;
import com.apps4society.repository.PrivilegeRepository;
import com.apps4society.repository.UserRepository;

import antlr.collections.List;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{

	boolean alreadySetup =false;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private FuncoesRepository funcoesRepository;
	
	@Autowired
	private PrivilegeRepository privilegeRepository;
	
	//@Autowired
	//private PasswordEncoder passwordEncoder;
	
	
	
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
		// TODO Auto-generated method stub
		
		if(alreadySetup) {
			return ;
		}
		Privilege readPrivilege
        = createPrivilegeIfNotFound("READ_PRIVILEGE");
      Privilege writePrivilege
        = createPrivilegeIfNotFound("WRITE_PRIVILEGE");

      Collection<Privilege> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);        
      createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
      createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

      Funcoes adminRole = funcoesRepository.findByName("ROLE_ADMIN");
      
      
      
     // User user = new User();
     // user.setNome("Osvaldo");
     // user.setLogin("lsbloo");
     // user.setPass(new BCryptPasswordEncoder().encode("6036236"));
     // user.setEmail("osvaldo.airon@dce.ufpb.br");
     // user.setRoles(Arrays.asList(adminRole));
     // userRepository.save(user);
       
       
      

      alreadySetup = true;
		
		
	}
	@Transactional
    private Privilege createPrivilegeIfNotFound(String name) {
  
        Privilege privilege = privilegeRepository.findByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            privilegeRepository.save(privilege);
        }
        return privilege;
    }
	@Transactional
    private Funcoes createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
  
        Funcoes role = funcoesRepository.findByName(name);
        if (role == null) {
            role = new Funcoes(name);
            role.setPrivileges(privileges);
           funcoesRepository.save(role);
        }
        return role;
    }

}
