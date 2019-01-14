package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.apps4society.model.AreaDeInteresseTuristico;
import com.apps4society.model.AtrativoTuristico;

import java.util.List;

import javax.transaction.Transactional;



@Repository
public interface AreaInteresseRepository extends JpaRepository<AreaDeInteresseTuristico,Long>{

	
	/*
	 * Verifica se ja existe uma area de interesse  com nome (x);
	 */
	@Query(value="SELECT * FROM area_de_interesse_turistico WHERE nome_area_turistica = ?1 and actived = true ",nativeQuery=true)
	List<AreaDeInteresseTuristico> checkExist(@Param("area_turistica") String area_turistica);
	
	/*
	 * 
	 */
	@Query(value="SELECT * FROM area_de_interesse_turistico WHERE nome_area_turistica = ?1 and actived = true ",nativeQuery=true)
	List<AreaDeInteresseTuristico> searchAreaName(@Param("area_turistica") String area_turistica);
	
	@Modifying
	@Transactional
	@Query(value="update AreaDeInteresseTuristico aI set aI.actived = false where aI.id = :id")
	public void desativeAreaInteresse(@Param("id") Long id);
}
