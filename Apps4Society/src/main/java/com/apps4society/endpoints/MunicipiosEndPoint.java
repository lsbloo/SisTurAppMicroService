package com.apps4society.endpoints;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apps4society.model.Municipios;
import com.apps4society.model.User;
import com.apps4society.repository.AtrativoTuristicoRepository;
import com.apps4society.repository.MunicipioRepository;
import com.apps4society.repository.UserRepository;
import com.apps4society.rolesmoldes.OperationFactory;
import com.apps4society.utilidades.Contador;
import com.apps4society.model.AtratativoTuristico;
import com.apps4society.exceptions.IndiceForaAlcance;
import java.util.ArrayList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="API REST Municipios")
@Transactional
@RestController
public class MunicipiosEndPoint implements OperationFactory{
	
	@Autowired
	private MunicipioRepository m;
	@Autowired
	private AtrativoTuristicoRepository at;
	
	protected static String saida="";
	protected static int[] result;
	protected static int total;
	
	
	@ApiOperation(value="Retorna todos os municipios")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/rest_municipios")
	protected List<Municipios> getMunicipio() throws InterruptedException {
		/*OK
		 * Retorna toda a lista de municipios que estao ativadas;
		 */
		List<Municipios> list_city = m.findByActived();
		sleep("GetMunicipio ALL");
		if(list_city.size()!=0) {
			System.out.print(" \n pass");
		}else {
			System.err.println("\n Nenhum municipio cadastrado!");
		}
		
	
		return list_city;
	}
	
	@ApiOperation(value="Procura um minicipio pelo ID especifico")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@GetMapping("/rest_municipioSearch/{id}")
	protected Optional<Municipios> getCliente(@PathVariable Long id) {
		/*OK
		 * Procura um municipio especifico pelo ID
		 */
		return m.findById(id);
	}
	
	@ApiOperation(value="Deleta um municipio pelo ID especifico")
	@ResponseStatus(value = HttpStatus.ACCEPTED)
	@RequestMapping(value="/del_rest_municipiodel/{id}",method=RequestMethod.GET)
	protected boolean deleteMunicipio(@PathVariable Long id) {
		/* requisao do metodo = DELETE;
		 * Desativa o municipio pelo seu ID;
		 * usando uma query nativa
		 */
		m.desableById(id);
		return true;
	}
	
	
	@ApiOperation(value="Pega todos os atrativos que tem em um municipio")
	@ResponseStatus(value=HttpStatus.ACCEPTED)
	@RequestMapping(value="/rest_search_atrativo_name_city/{nome_city}",method=RequestMethod.GET)
	protected List<AtratativoTuristico> pegaAtrativo (@PathVariable String nome_city) throws InterruptedException
	
	{
		/*
		 * Pesquisa por todos os atrativos turisticos em um determinado municipio
		 * 1 Municipio pode ter + de 1 atrativo turistico;
		 * Contudo um o municipio de um atrativo X, pode não esta na tabela de municipios
		 */
		try {
			//System.out.println(nome_city);
			
			System.out.println(at.findByFiltro(nome_city).get(0).getComoChegar());
			
			if(at.findByFiltro(nome_city).size()>0) {
				/*
				 * Existe um atrativo naquele Municipio-
				 */
				int tamanho = at.findByFiltro(nome_city).size();
				System.out.println(ExistAtrativoNoMuncipio(nome_city,tamanho));
				List<AtratativoTuristico> list_ats = at.findByFiltro(nome_city);
				sleep("GetAtrativoBuscaPorMunicipio");
				if(list_ats.size()!=0) {
					System.out.print(" \n pass");
					return list_ats;
				}else {
					System.err.println("\n Nenhum Atrativo Turistico retornado!");
				}
				
				
			}
			
		}catch(IndexOutOfBoundsException e) {
			System.err.println(notExistsAtrativoNoMunicipio(nome_city));
			throw new IndiceForaAlcance();
			
		}
		return null;
		
		
	}
	public String notExistsAtrativoNoMunicipio(String nome_city) {
		saida = "Não Existe um Atrativo no Municipio: "+nome_city;
		return saida;
	}
	public static String ExistAtrativoNoMuncipio(String nome_city,int tamanho) {
		saida = "ArrayList de Atrativo retornado com sucesso no municipio: "+ nome_city +"\n"+ "Tamanho da Lista: "+tamanho;
		return saida;
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
