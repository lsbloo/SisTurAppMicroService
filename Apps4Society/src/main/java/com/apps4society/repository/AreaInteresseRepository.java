package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.apps4society.model.AreaDeInteresseTuristico;
import java.util.List;



@Repository
public interface AreaInteresseRepository extends JpaRepository<AreaDeInteresseTuristico,Long>{

	
	
	@Query(value="SELECT * FROM area_interesse_turistico WHERE actived = true and nome_area_turistica=?1",nativeQuery=true)
	List<AreaDeInteresseTuristico> searchAreaName();
	
}
