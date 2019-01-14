package com.apps4society.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apps4society.model.AtrativoTuristico;
import com.apps4society.model.Municipios;
import java.util.List;

import javax.transaction.Transactional;

public interface MunicipioRepository extends JpaRepository<Municipios,Long>{
	
	
	@Query(nativeQuery=true,value="SELECT * FROM municipios WHERE id=?1")
	Municipios findActivedById(@Param("id") Long id);
	
	/*
	 * Verifica se ja existe um municipio com nome (x);
	 */
	@Query(value="SELECT * FROM municipios WHERE actived = true and nome_cidade = ?1",nativeQuery=true)
	List<Municipios> checkExist(@Param("nome_cidade") String nome_cidade);
	
	/*
	 * Retorna todos os municipios que estao habilitados (actived);
	 */
	@Query(value="SELECT * FROM municipios WHERE actived = true",nativeQuery=true)
	List<Municipios> findAllByActived();
	
	/*
	 * a ideia é desativar um municipio caso o administrador queira "deletar" da aplicação
	 * porem os dados ainda ficaram no banco de dados caso ele queira pegar esses dados novamente
	 * O endPoint controlador precisa de uma anotação @Transactional, pra poder utilizar
	 * querys nativas de update/delete se nao uma excpetion é disparada
	 * += mais vou tratar esssa exception so pra ajudar;
	 */
	@Modifying
	@Transactional
	@Query(value="update Municipios m set m.actived = false where m.id = :id")
	void desableById(@Param("id") Long id);
	
	
	/**
	 * Query of Update citys; PERMISSION ADMIN!
	 * 
	 * 
	 * @param nome_cidade
	 * @param codigo_validacao
	 * @param area_territorial
	 * @param descricao
	 * @param estado
	 * @param email_responsavel_preenchimento
	 * @param img_url
	 * @param informacoes_relevantes
	 * @param string
	 * @param string2
	 * @param nome_responsavel_preenchimento
	 * @param string3
	 * @param site
	 * @param fonte_informacoes
	 * @param actived
	 * @param contatos_responsavel_preenchimento
	 * @param id
	 * 
	 * METHOD VOID !; controller return redirect:;
	 * 
	 */
	@Modifying
	@Transactional
	@Query(value="update Municipios m set m.nome_cidade=?1, m.codValidacao=?2, m.areaTerritorial=?3, m.descricao=?4,"
			+ "m.estado=?5, m.email_responsavel_preenchimento=?6, m.imgUrl=?7, m.informacoesRelevantes=?8, m.latitude=?9, m.longitude=?10,"
			+ "m.nome_responsavel_preenchimento=?11, m.populacao=?12, m.site=?13, m.fonte_informacoes=?14, m.actived=?15, m.contatos_responsavel_preenchimento=?16  where id=?17")
	void updateMunicipio(
			@Param("nome_cidade") String nome_cidade, // 1
			@Param("codigo_validacao") String codigo_validacao,  // 2
			@Param("area_territorial") String area_territorial,  // 3
			@Param("descricao") String descricao ,  // 4
			@Param("estado")  String estado, // 5
			@Param("email_responsavel_preenchimento") String email_responsavel_preenchimento,  // 6
			@Param("img_url") String img_url, // 7
			@Param("informacoes_relevantes") String informacoes_relevantes, //8
			@Param("latitude") String string , //9
			@Param("longitude") String string2, //10
			@Param("nome_responsavel_preenchimento") String nome_responsavel_preenchimento, // 11
			@Param("populacao") String string3,  // 12
			@Param("site") String site , // 13
			@Param("fonte_informacoes") String fonte_informacoes, // 14
			@Param("actived") boolean actived , // 15
			@Param("contatos_responsavel_preenchimento") String contatos_responsavel_preenchimento, // 16
			@Param("id") Long id // 17
			
			);
	
}
