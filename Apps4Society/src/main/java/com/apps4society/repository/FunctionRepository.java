package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps4society.model.Functions;

@Repository
public interface FunctionRepository extends JpaRepository<Functions,Long>{

	
	
	Functions findByName(String name);
}
