package com.apps4society.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apps4society.model.AtratativoTuristico;

@Repository
public interface AtrativoTuristicoRepository extends JpaRepository<AtratativoTuristico,Long>{

	
	
	/*
	 * Cria uma Query Nativa no banco de dados e retorna uma Lista de atrativos
	 * que esta presente no municipio (x), passado pelo filtro;
	 */
	@Query(value="SELECT * FROM atrativos_turisticos WHERE cidade= ?1",nativeQuery=true)
	ArrayList<AtratativoTuristico> findByFiltro(@Param("nome_city")String nome_city);
	
	
	
	
}
