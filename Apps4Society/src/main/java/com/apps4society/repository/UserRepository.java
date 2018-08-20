package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.apps4society.model.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long>{
	

	User findByLogin(String login);

}
