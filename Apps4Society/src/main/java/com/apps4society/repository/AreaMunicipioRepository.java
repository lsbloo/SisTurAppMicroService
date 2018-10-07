package com.apps4society.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.apps4society.model.AreaMunicipio;

public interface AreaMunicipioRepository extends CrudRepository<AreaMunicipio,Long>{
	/*
	 * 
	 */
	
	@Query(value="SELECT * FROM area_municipio where municipio_id = ?1 and area_interesse_id = ?2",nativeQuery=true)
	AreaMunicipio searchAreaMun(@Param("municipio_id") Long municipio_id , @Param("area_interesse_id") Long area_interesse_id
			);
	
	
	@Query(value="SELECT * FROM area_municipio where area_interesse_id = ?1",nativeQuery=true)
	List<AreaMunicipio> SearchMunArea(@Param("area_interesse_id") Long area_interesse_id);
	
	
	
}
