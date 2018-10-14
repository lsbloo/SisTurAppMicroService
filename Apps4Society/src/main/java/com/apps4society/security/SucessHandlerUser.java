package com.apps4society.security;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.hibernate.mapping.Collection;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collections;
/*
 * 
 */
@Controller
@Configuration
@EnableWebSecurity
public class SucessHandlerUser implements AuthenticationSuccessHandler{

	/*
	 * (non-Javadoc)
	 * Verifica se a autenticação foi um sucesso a partir de um objeto AuthenticationSuccessHandler;
	 * redirecionar o usuario para a tela de login em questão.
	 * o metodo post utilizando no meu framgmento/login; so auxilia o security a realizar o login
	 * nao é possivel utilizar um controle padrao;
	 *  && é preciso definir a Role do usuario (Admin,User) na criação do mesmo.
	 *  aproveitar o cod! do functionR
	 * @see org.springframework.security.web.authentication.AuthenticationSuccessHandler#onAuthenticationSuccess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, org.springframework.security.core.Authentication)
	 */
	protected Log logger = LogFactory.getLog(this.getClass());
	private java.util.Collection<? extends GrantedAuthority> authorities;
	 
    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
 
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication)
      throws IOException {
  
        handle(request, response, authentication);
        clearAuthenticationAttributes(request);
    }
 
    protected void handle(HttpServletRequest request, 
      HttpServletResponse response, Authentication authentication)
      throws IOException {
  
        String targetUrl = determineTargetUrl(authentication);
 
        if (response.isCommitted()) {
            logger.debug(
              "Response has already been committed. Unable to redirect to "
              + targetUrl);
            return;
        }
 
        redirectStrategy.sendRedirect(request, response, targetUrl);
    }
    
    
 
    protected String determineTargetUrl(Authentication authentication) {
    	/*
    	 * Metodo principal da  class HandlerSucess;
    	 * verifica as permissões de acesso do usuario em questão dependendo de sua permissao
    	 * o redireciona para uma pagina especifica;
    	 * (É NECESSARIO UM "ROLE" PARA O USUARIO)
    	 */
        boolean isUser = false;
        boolean isAdmin = false;
        authorities =  authentication.getAuthorities();
        System.out.println("KASAKPOKS; !"+authorities);
        for (GrantedAuthority grantedAuthority : authorities) {
        	
            if (grantedAuthority.getAuthority().equals("ROLE_USER")) {
                isUser = true;
                
                break;
            } else if (grantedAuthority.getAuthority().equals("ROLE_ADMIN")) {
                isAdmin = true;
                break;
            }
        }

        if (isUser) {
        	/*
        	 * a ideia é que, quando o usuario for autenticado e tiver a permissao 
        	 * seja redirecionado a partir do sucessHandler()
        	 */
        	
        	return "/acessoUsuario";
        } else if (isAdmin) {
        	
        	return "/acessoAdministrador";
        } else {
            throw new IllegalStateException();
        }
    }
 
    
    
    protected void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(true);
        if (session == null) {
            return;
        }
        session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    }
 
    public void setRedirectStrategy(RedirectStrategy redirectStrategy) {
        this.redirectStrategy = redirectStrategy;
    }
    protected RedirectStrategy getRedirectStrategy() {
        return redirectStrategy;
    }

}
