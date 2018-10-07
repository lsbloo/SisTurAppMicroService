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

import com.apps4society.model.Funcoes;
import com.apps4society.model.Privilege;
import com.apps4society.repository.FuncoesRepository;
import com.apps4society.repository.UserRepository;

@Repository
@Transactional
public class UserDetailService implements UserDetailsService{

	@Autowired
	private UserRepository repository;
	
	@Autowired
	private FuncoesRepository funcoesRepository;
	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		com.apps4society.model.User u = repository.findByLogin(login);
		System.out.println(u.getAuthorities());
		
		try {
			//User u = repository.findByLogin(login);
			if(u==null) {
				
				return new User(" "," ",true,true,true,true,getAuthorities(Arrays.asList(funcoesRepository.findByName("ROLE_USER"))));
				
			}
			
		}catch(InternalAuthenticationServiceException e) {
			senhaErrada();
		}
		
		//return new User(u.getLogin(),u.getPass(),true,true,true,true,u.getAuthorities());
		return new User(
				/*
				 * EU TROQUEI O PARAMETRO ENABLED DA CLASSE USER -(USERDETAILS)
				 * POR MEU ATRIBUTO U.ISACTIVED() PQ? - PQ OS DOIS NESSA LOGICA SAO A MESMA COISA
				 * SE O USUARIO NAO ESTA HABILITADO ENTAO ELE NAO PODE REALIZAR LOGIN
				 * JA EVITA UMA CONSULTA NO BANCO;
				 */
		          u.getEmail(), u.getPass(), u.isActived(), true, true, 
		          true, getAuthorities(u.getRoles()));
	}
	
	private Collection<? extends GrantedAuthority> getAuthorities(
		      Collection<Funcoes> roles) {
		  
				/*
				 * Pego o privilegio com a role
				 * e dps verifico se tem "authorities" metodo grantedauthories();
				 * 
				 */
		        return getGrantedAuthorities(getPrivileges(roles));
		    }
		 
		    private List<String> getPrivileges(Collection<Funcoes> roles) {
		    	/*
		    	 * Mudei o get da role de priveleges para authority()
		    	 * por algum motivo ele nao esttava pegando o "privilege". Mas mesmo
		    	 * assim continuava retornando o AUTHORITY que é o que eu precisava
		    	 * a ideia do algoritmo é a mesma. 
		    	 * 
		    	 */
		  
		        List<String> privileges = new ArrayList<>();
		       
		        List<String> collection = new ArrayList<>();
		        //System.out.print("COLECCTIONS: "+collection.get(0));
		        for (Funcoes role : roles) {
		        	/*
		        	 * recolhe as authoritys
		        	 */
		            collection.add(role.getAuthority());
		        }
		        if(collection!=null) {
		        	
		        	
		        	for(int i =0 ; i<collection.size();i++) {
		        		//System.out.println("NAO POSSO DESISTIR "+collection.get(i));
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
		       // System.err.println("KKKKKKKKKKKKKKKKKKK" + authorities);
		        return authorities;
		    }


	public String senhaErrada() {
		return "eventos/senhaErrada";
	}

}
