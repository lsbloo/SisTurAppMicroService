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
	
	
	@Query(nativeQuery=true,value="SELECT * FROM usuarios where id=?1")
	public User getUserId(@Param("id") Long id); 
	
	
	
	@Modifying
	@Transactional
	@Query(value="update User u set u.actived = false where u.id=:id")
	public void desativeUser(@Param("id") Long id);
	
	
	/**
	 * Query of Edit User:
	 * Permission ADMIN;
	 */
	@Modifying
	@Transactional
	@Query(value="update User u set u.actived=?1, u.login=?2, u.nome=?3, "
			+ "u.pass=?4, u.email=?5 where u.id=?6 ")
	public void 
	editUser(
			@Param("actived") 
			boolean actived ,
			@Param("login") String login,
			@Param("nome") String nome,
			@Param("pass") String pass,
			@Param("email") String email, 
			@Param("id") Long id
			
			);
	
	
	@Query(value="SELECT * FROM usuarios where login = ?1 ",nativeQuery=true)
	List<User> checkExist(@Param("login") String login);
}