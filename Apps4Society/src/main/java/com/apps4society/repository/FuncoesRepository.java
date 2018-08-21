package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.apps4society.model.Funcoes;

@Repository
public interface FuncoesRepository extends JpaRepository<Funcoes,Long>{

	
	
	Funcoes findByName(String name);
}
