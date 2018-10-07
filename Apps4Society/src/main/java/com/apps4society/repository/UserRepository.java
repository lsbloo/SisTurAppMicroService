package com.apps4society.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.apps4society.model.User;
import java.util.List;

import javax.transaction.Transactional;
@Repository
public interface UserRepository extends CrudRepository<User,Long>{
	

	User findByLogin(String login);
	
	
	
	
	@Modifying
	@Transactional
	@Query(value="update User u set u.actived = false where u.id=:id")
	public void desativeUser(@Param("id") Long id);
	
	
	@Query(value="SELECT * FROM usuarios where login = ?1 ",nativeQuery=true)
	List<User> checkExist(@Param("login") String login);
}
