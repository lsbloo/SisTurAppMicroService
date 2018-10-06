package com.apps4society.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apps4society.model.AtratativoTuristico;
import com.apps4society.model.Municipios;
import java.util.List;

import javax.transaction.Transactional;

public interface MunicipioRepository extends JpaRepository<Municipios,Long>{
	
	
	/*
	 * Verifica se ja existe um municipio com nome (x);
	 */
	@Query(value="SELECT * FROM municipios WHERE actived = true and nome_cidade = ?1",nativeQuery=true)
	List<Municipios> checkExist(@Param("nome_cidade") String nome_cidade);
	
	/*
	 * Retorna todos os municipios que estao habilitados (actived);
	 */
	@Query(value="SELECT * FROM municipios WHERE actived = true",nativeQuery=true)
	List<Municipios> findByActived();
	
	
	
	
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
}
