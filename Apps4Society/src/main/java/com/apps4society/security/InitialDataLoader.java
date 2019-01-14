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

import com.apps4society.model.Functions;
import com.apps4society.model.Privilege;
import com.apps4society.model.User;
import com.apps4society.repository.FunctionRepository;
import com.apps4society.repository.PrivilegeRepository;
import com.apps4society.repository.UserRepository;
import com.apps4society.services.UserService;

import antlr.collections.List;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent>{

	boolean alreadySetup =false;
	
	
	/**
	 * UserSERVICE
	 */
	private final UserService userService;
	
	@Autowired
	public InitialDataLoader(UserService userService) {
		
		this.userService=userService;
	}
	
	
	
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

      Functions adminRole = this.userService.getFunctionByName("ROLE_ADMIN");
      

      alreadySetup = true;
		
		
	}
	@Transactional
    private Privilege createPrivilegeIfNotFound(String name) {
  
        Privilege privilege = this.userService.getPrivilegeByName(name);
        if (privilege == null) {
            privilege = new Privilege(name);
            this.userService.savePrivilege(privilege);
        }
        return privilege;
    }
	@Transactional
    private Functions createRoleIfNotFound(
      String name, Collection<Privilege> privileges) {
  
        Functions role = this.userService.getFunctionByName("ROLE_ADMIN");
        if (role == null) {
            role = new Functions(name);
            role.setPrivileges(privileges);
           this.userService.saveRole(role);
        }
        return role;
    }

}
