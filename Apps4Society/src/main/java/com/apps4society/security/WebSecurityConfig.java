package com.apps4society.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	/*
	 * Classe principal para a realização de autenticações;
	 * Utiliza o JPA(Persistencia); postgresql
	 * Metodo configure(HttpSecurity http): define quais Urls estão disponiveis para todos "public"
	 * para users (algumas que vou definir ainda.)
	 * pra admin(visualização de dados e alteração)
	 * irei deixar o swagger public pra quem quiser visualizar.
	 * 
	 * 
	 */

	@Autowired
	private UserDetailService us;
	@Autowired
	private SucessHandlerUser is;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		/*
		 * Define as urls de acesso (user,admin) or public
		 * cria o recurso de login e loggout a partir de um sucessHandler
		 * Handler esse que realizaça uma operação especefica; de autenticacação 
		 * e redirecinonamento de pagina
		 *  ÇÇ ainda nao esta completamente implementado;
		 */
		
		
		http.csrf().disable().authorizeRequests().antMatchers(HttpMethod.GET,"/login",
				"/sisturinfo/endpoints/municipios",
				"/sisturinfo/endpoints/municipios/list",
				"/sisturinfo/endpoints/municipios/search/{id}",
				"/sisturinfo/endpoints/atrativo",
				"/sisturinfo/endpoints/atrativo/list",
				"/sisturinfo/endpoints/atrativo/search/{id}"
				).
		permitAll().
		antMatchers(HttpMethod.GET,
				"/swagger-ui/**",
				"/swagger-ui.html#/"
				)
		.hasRole("ADMIN").antMatchers(HttpMethod.POST,"swagger-ui#/**")
		.hasRole("ADMIN")
		.anyRequest().authenticated()
		.and().formLogin().loginPage("/login").permitAll().successHandler(myAuthenticationSuccessHandler()).and().
		logout().addLogoutHandler(myLogoutSucessHandler())
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
		
		

	}
	
	@Bean
	public  MyLogoutSucessHandler myLogoutSucessHandler() {
		return new MyLogoutSucessHandler();
	}
	
	 @Bean
	    public AuthenticationSuccessHandler myAuthenticationSuccessHandler(){
	        return new SucessHandlerUser();
	    }
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		/*
		 * realiza a autenticação do usuario se o mesmo existir e se a sua senha
		 * criptografada for compativel com a mesma q ele colocou no cad;
		 */
		auth.userDetailsService(us).passwordEncoder(new BCryptPasswordEncoder());
		
		
		
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		/*
		 * Define o que o security deve ignorar 
		 * importante: caminhos não presentes aqui nao seram reconhecidos
		 * inclusive arquivos html,css,javascrript; jpg etc;
		 * 
		 */
		web.ignoring().antMatchers("/mycss/**","/materialize/**","/eventos/**","/imagens/**","/fragments/**","/utils/**");
	}
}
