package com.apps4society.services;

import java.util.Arrays;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.apps4society.repository.FunctionRepository;
import com.apps4society.repository.PrivilegeRepository;
import com.apps4society.repository.UserRepository;
import com.apps4society.model.Functions;
import com.apps4society.model.Privilege;
import com.apps4society.model.User;

@Service
@Transactional
public class UserService {
	/**
	 * UserRepository
	 */

	private final UserRepository userRepository;

	/**
	 *FunctionRepository
	 */
	private final FunctionRepository functionRepository;
	
	/**
	 * PrivilegeRepository
	 */
	private final PrivilegeRepository privilegeRepository;
	
	

	
	@Autowired
	public UserService(UserRepository userRepository , FunctionRepository functionRepository, PrivilegeRepository privilegeRepository) {
		this.userRepository=userRepository;
		this.functionRepository=functionRepository;
		this.privilegeRepository=privilegeRepository;
	}
	
	
	
	public void saveRole(Functions functions) {
		this.functionRepository.save(functions);
	}
	public void savePrivilege(Privilege privilege) {
		this.privilegeRepository.save(privilege);
	}
	public Privilege getPrivilegeByName(String name) {
		return this.privilegeRepository.findByName(name);
	}
	
	public List<User> findAllUser(){
		return this.userRepository.findAllUserActived();
	}
	
	public User findByLogin(String login) {
		return this.userRepository.findByLogin(login);
	}
	
	
	public Functions getFunctionByName(String name) {
		return this.functionRepository.findByName(name);
	}
	
	
	public User findUserById(Long id) {
		return this.userRepository.findUserById(id);
	}
	
	
	public void editUser(User user , Long identifier) {
		this.userRepository.editUser(user.isActived(), user.getLogin(), user.getNome(), user.getPass(), user.getEmail(), identifier);
	}
	
	public void desativeUser(Long identifier) {
		this.userRepository.desativeUser(identifier);
	}
	
	public boolean checkUserExists(User user) {
		if(this.userRepository.checkExist(user.getLogin()).size()>=1) return true;
		return false;
	}
	
	
	public void createNewUser(User user) {
		if(!checkUserExists(user)) {
			String pass = user.getPass();
			user.setRoles(Arrays.asList(this.functionRepository.findByName("ROLE_USER")));
			user.setPass(new BCryptPasswordEncoder().encode(pass)); 
			user.setActived(true);
			this.userRepository.save(user);
			
		}
	}
}
