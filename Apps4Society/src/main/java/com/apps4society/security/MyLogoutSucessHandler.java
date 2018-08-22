package com.apps4society.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Component;

@Configuration
@Component
public class MyLogoutSucessHandler implements LogoutSuccessHandler, LogoutHandler{

	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		
		
		
	}

	@Override
	public void logout(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
		// TODO Auto-generated method stub
		/*
		 * Implementa o logout do usuario a partir do Logout Handler
		 * essa classe é instanciada na classe SecurityConfig;
		 * 
		 */
		
		if(authentication != null) {
			System.out.println("NOME DA AUTENTICACÇÃO"+authentication.getName());
		}
		//perform other required operation
		String URL = request.getContextPath() + "/";
		//System.err.println("URLLLLLLL " + URL);
		response.setStatus(HttpStatus.OK.value());
		try {
			response.sendRedirect(URL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
