package com.apps4society.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apps4society.model.AtratativoTuristico;
import com.apps4society.model.Municipios;

public interface MunicipioRepository extends JpaRepository<Municipios,Long>{
	
	

}
