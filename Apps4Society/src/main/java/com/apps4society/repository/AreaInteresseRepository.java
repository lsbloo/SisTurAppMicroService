package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps4society.model.AreaDeInteresseTuristico;



@Repository
public interface AreaInteresseRepository extends JpaRepository<AreaDeInteresseTuristico,Long>{

	
	
}
