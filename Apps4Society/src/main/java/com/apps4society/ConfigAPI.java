package com.apps4society;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.models.Contact;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import springfox.documentation.service.VendorExtension;


@Configuration
@EnableSwagger2
public class ConfigAPI {
	/*
	 * Configura a UI do swagger para exibição dos metodos REST.
	 * 
	 */

	@Bean
    public Docket productApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.apps4society"))
                .paths(PathSelectors.regex("/sisturinfo/endpoints.*"))
                .build()
                ;
    }
	
   
    
    private springfox.documentation.service.Contact contato() {
    	springfox.documentation.service.Contact cx = new springfox.documentation.service.Contact("OsvaldoAiron","www.github.com/lsbloo", null);
    	
    	return cx;
    }
}
