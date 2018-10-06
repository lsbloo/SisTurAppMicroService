package com.apps4society.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apps4society.model.AtratativoTuristico;
import java.util.List;


@Repository
public interface AtrativoTuristicoRepository extends JpaRepository<AtratativoTuristico,Long>{

	/*
	 * Verifica se ja existe um atrativo com nome (x) , no municipio(x);
	 */
	@Query(value="SELECT * FROM atrativos_turisticos WHERE nome_atrativo = ?1 and actived = true and cidade = ?2",nativeQuery=true)
	List<AtratativoTuristico> checkExist(@Param("nome_atrativo") String nome_atrativo
			,@Param("nome_city") String nome_city);
	
	/*
	 * Cria uma Query Nativa no banco de dados e retorna uma Lista de atrativos
	 * que esta presente no municipio (x), passado pelo filtro;
	 */
	@Query(value="SELECT * FROM atrativos_turisticos WHERE cidade= ?1 and actived = true",nativeQuery=true)
	ArrayList<AtratativoTuristico> findByFiltro(@Param("nome_city")String nome_city);
	
	
	/*
	 * Retorna todos os atrativos turisticos que estao habilitados (actived);
	 */
	@Query(value="SELECT * FROM atrativos_turisticos WHERE actived = true",nativeQuery=true)
	ArrayList<AtratativoTuristico> findByActived();
	
	/*
	 * a ideia é desativar um atrativo caso o administrador queira "deleltar" da aplicação
	 * porem os dados ainda ficaram no banco de dados caso ele queira pegar esses dados novamente
	 * O endPoint controlador precisa de uma anotação @Transactional, pra poder utilizar
	 * querys nativas de update/delete se nao uma excpetion é disparada
	 * += mais vou tratar esssa exception so pra ajudar;
	 */
	@Modifying
	@Query(value="update AtratativoTuristico at set at.actived = false where at.id = :id")
	public void desativeATId(@Param("id") Long id);
	
	
	
}
