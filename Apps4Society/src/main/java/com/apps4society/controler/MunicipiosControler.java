package com.apps4society.controler;

import java.util.List;
import java.util.Optional;

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
import com.apps4society.model.AtratativoTuristico;
import com.apps4society.exceptions.IndiceForaAlcance;
import java.util.ArrayList;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://localhost:4200")
@Api(value="API REST Municipios")
@RestController
public class MunicipiosControler {
	
	@Autowired
	private MunicipioRepository m;
	@Autowired
	private AtrativoTuristicoRepository at;
	
	
	@ApiOperation(value="Retorna todos os municipios")
	@GetMapping("/rest_municipios")
	public List<Municipios> getMunicipio() {
		/*OK
		 * Retorna toda a lista de municipios
		 */
		return m.findAll();
	}
	
	@ApiOperation(value="Procura um minicipio pelo ID especifico")
	@GetMapping("/rest_municipioSearch/{id}")
	public Optional<Municipios> getCliente(@PathVariable Long id) {
		/*OK
		 * Procura um municipio especifico pelo ID
		 */
		return m.findById(id);
	}
	
	@ApiOperation(value="Deleta um municipio pelo ID especifico")
	@ResponseStatus(value = HttpStatus.NO_CONTENT)
	@RequestMapping(value="/del_rest_municipiodel/{id}",method=RequestMethod.GET)
	public boolean deleteMunicipio(@PathVariable Long id) {
		/* requisao do metodo = DELETE;
		 * DELETA UM MUNICIPIO PELO SEU ID
		 */
		m.deleteById(id);
		return true;
	}
	
	
	@ApiOperation(value="Pega todos os atrativos que tem em um municipio")
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@RequestMapping(value="/rest_search_atrativo_name_city/{nome_city}",method=RequestMethod.GET)
	public ArrayList<AtratativoTuristico> pegaAtrativo (@PathVariable String nome_city)
	
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
				return at.findByFiltro(nome_city);
				
				
			}
			
		}catch(IndexOutOfBoundsException e) {
			System.err.println(notExistsAtrativoNoMunicipio(nome_city));
			throw new IndiceForaAlcance();
			
		}
		return null;
		
		
	}
	public String notExistsAtrativoNoMunicipio(String nome_city) {
		String saida = "Não Existe um Atrativo no Municipio: "+nome_city;
		return saida;
	}
	public static String ExistAtrativoNoMuncipio(String nome_city,int tamanho) {
		String saida = "ArrayList de Atrativo retornado com sucesso no municipio: "+ nome_city +"\n"+ "Tamanho da Lista: "+tamanho;
		return saida;
	}
}
