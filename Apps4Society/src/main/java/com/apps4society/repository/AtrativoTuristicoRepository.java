package com.apps4society.repository;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apps4society.model.AtrativoTuristico;
import java.util.List;


@Repository
public interface AtrativoTuristicoRepository extends JpaRepository<AtrativoTuristico,Long>{

	@Query(value="SELECT * FROM atrativos_turisticos WHERE nome_atrativo = ?1 and actived = true and cidade = ?2",nativeQuery=true)
	List<AtrativoTuristico> checkExist(@Param("nome_atrativo") String nome_atrativo
			,@Param("nome_city") String nome_city);
	

	@Query(value="SELECT * FROM atrativos_turisticos WHERE cidade= ?1 and actived = true",nativeQuery=true)
	ArrayList<AtrativoTuristico> findByName(@Param("nome_city")String nome_city);
	
	
	@Query(value="select * from atrativos_turisticos where actived=true and id=:id",nativeQuery=true)
	AtrativoTuristico findByIdActived(@Param("id") Long id);
	
	@Query(value="SELECT * FROM atrativos_turisticos WHERE actived = true",nativeQuery=true)
	List<AtrativoTuristico> findAllActived();
	
	
	@Modifying
	@Transactional
	@Query(value="update AtrativoTuristico at set at.actived = false where at.id = :id")
	void desative(@Param("id") Long id);
	
	
}
