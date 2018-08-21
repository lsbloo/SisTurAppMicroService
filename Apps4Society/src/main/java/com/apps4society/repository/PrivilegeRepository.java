package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.apps4society.model.Privilege;

@Repository
public interface PrivilegeRepository extends JpaRepository<Privilege,Long>{

	Privilege findByName(String name);
}
