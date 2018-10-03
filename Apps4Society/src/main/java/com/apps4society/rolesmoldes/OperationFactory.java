package com.apps4society.rolesmoldes;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.PathVariable;
public interface OperationFactory {
	/*
	 * Criar uma fabrica de metodos para os EndpointsBase
	 */
	
	void validation(String method) throws InterruptedException;
	 
	
	

}
