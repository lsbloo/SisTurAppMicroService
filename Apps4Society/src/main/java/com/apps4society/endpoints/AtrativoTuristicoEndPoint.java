package com.apps4society.endpoints;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.model.AtratativoTuristico;
import com.apps4society.model.Municipios;
import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.rolesmoldes.OperationFactory;
import com.apps4society.utilidades.Contador;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="API REST Atrativos")
@Transactional
@RestController
public class AtrativoTuristicoEndPoint implements OperationFactory{
	
	@Autowired
	AtrativoTuristicoRepository r;
	
	@ApiOperation(value="Retorna todos os Atrativos Turisticos Cadastrados")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/rest_atrativosTuristicos")
	protected List<AtratativoTuristico> getAtratativoTuristico() throws InterruptedException {
		
		/*
		 * Retorna todos os atrativos que estão ativados
		 * usando uma query nativa;
		 */
		List<AtratativoTuristico> list_at = r.findByActived();
		sleep("Get Atrativos Turisticos ALL");
		if(list_at.size()>0) {
			System.out.println("\n pass");
		}else {
			System.err.println(" \n nenhum atrativo turistico cadastrado ");
		}
		return list_at;
	}
	
	@ApiOperation(value="Procura um atrativo especifico pelo ID")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/rest_atrativoTuristicoSearch/{id}")
	protected Optional<AtratativoTuristico> getAtratativoTuristico(@PathVariable Long id) {
		/*OK
		 * Procura um atratativoTuristico especifico pelo ID
		 */
		return r.findById(id);
	}
	@ApiOperation(value="Deleta um atrativo especifico pelo ID")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@RequestMapping(value="/del_rest_atrativoTuristicodel/{id}",method=RequestMethod.GET)
	protected boolean deleteAtratativoTuristico(@PathVariable Long id) {
		/* requisao do metodo = DELETE;
		 * Desatica o atrativo turistico pelo seu ID;
		 * usando uma query nativa
		 */
		r.desativeATId(id);
		return true;
	}

	@Override
	public void sleep(String method) throws InterruptedException {
		// TODO Auto-generated method stub
		
		/*
		 * 
		 */
		Contador contador = new Contador(0,99);
		contador.setName(method);
		contador.sleep(3000);
		contador.start();
		try {
			contador.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Metodo: "+method + " \n xf: " +contador.getTotal()+"%");
		}

	

}
