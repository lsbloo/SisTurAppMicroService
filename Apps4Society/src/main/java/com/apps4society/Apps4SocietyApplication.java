package com.apps4society;



import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@SpringBootApplication
public class Apps4SocietyApplication {

	public static void main(String[] args) {
		SpringApplication.run(Apps4SocietyApplication.class, args);
	}
	
	protected SpringApplicationBuilder configure(SpringApplicationBuilder app) {
		return app.sources(Apps4SocietyApplication.class);
	}
	
	@RequestMapping("/home")
	public String indexHTML() {
		return "/src/main/resources/templates/index.html";
	}
}